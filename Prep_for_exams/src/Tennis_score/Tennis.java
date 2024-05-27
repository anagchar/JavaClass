package Tennis_score;

import Tennis_score.Tennis.Advantage;
import Tennis_score.Tennis.Advantage.Won;
import Tennis_score.Tennis.Regular;

/**
 * @invar | 0 < getServerScore() && 40 > getServerScore()
 * @invar | 0 < getReceiverScore() && 40 > getReceiverScore()
 */
sealed abstract class Tennis permits Regular, Advantage, Won {
	
	/**
	 * @invar | 0 < ServerScore && ServerScore <= 40
	 * @invar | 0 < ReceiverScore && ReceiverScore <= 40
	 * 
	 * @representationObject
	 * 
	 */
	protected int ServerScore;
	protected int ReceiverScore;
	
	public int getServerScore() {
		return this.ServerScore;
	}
	
	public int getReceiverScore() {
		return this.ReceiverScore;
	}
	
	/**
	 * 
	 * @pre | score > 0 && score <= 40
	 * 
	 * @post | getServerScore() == score
	 */
	public void setServerScore(int score) {
		this.ServerScore = score;
	}
	
	/**
	 * @pre | score > 0 && score <= 40
	 * 
	 * @post | getReceiverScore() == score
	 */
	public void setReceiverScore(int score) {
		this.ReceiverScore = score;
	}
	
	public abstract String getState();
	
	public abstract Tennis nextStateAfterServerWins();

	
	final class Regular extends Tennis {
		
		/**
		 * @pre | serverScore == receiverScore
		 * @pre | serverScore > 0 && serverScore <= 40
		 */
		public Regular(int serverScore, int receiverScore) {
			this.ServerScore = serverScore;
			this.ReceiverScore = receiverScore;
		}
		
		@Override
		public String getState() {
			return "Regular";
		}
		
		@Override
		public Tennis nextStateAfterServerWins() {
	        if (this.ServerScore == 30) {
	            return new Regular(40, this.ReceiverScore);
	        } else if (this.ServerScore == 40 && this.ReceiverScore < 40) {
	            return new Won(this.ServerScore + 10, this.ReceiverScore);
	        } else if (this.ServerScore == 40 && this.ReceiverScore == 40) {
	            return new Advantage(50, this.ReceiverScore);
	        } else {
	            return new Regular(this.ServerScore + 15, this.ReceiverScore);
	        }
	    }
	}
	
	final class Advantage extends Tennis {
		
		/**
		 * 
		 * @pre | serverScore != receiverScore
		 * @pre | serverScore > 0 && serverScore <= 40
		 * @pre | receiverScore > 0 && receiverScore <= 40
		 */
		public Advantage(int serverScore, int receiverScore) {
			this.ServerScore = serverScore;
	        this.ReceiverScore = receiverScore;
		}
		
		public boolean hasServerAdvantage() {
			return ServerScore > ReceiverScore;
		}
		
		public boolean hasReceiverAdvantage() {
			return ServerScore < ReceiverScore;
		}
		
	    @Override
	    public String getState() {
	        return "Advantage";
	    }
	    
	    @Override
	    public Tennis nextStateAfterServerWins() {
	        if (hasServerAdvantage()) {
	            return new Won(this.ServerScore + 10, this.ReceiverScore);
	        } else {
	            return new Regular(40, 40);
	    }
	}
	
	final class Won extends Tennis {
		
		private String winner;
		
		public Won(int serverScore, int receiverScore) {
			this.ServerScore = serverScore;
	        this.ReceiverScore = receiverScore;
	        this.winner = determineWinner();
		}
		
	    private String determineWinner() {
	        if (ServerScore > ReceiverScore) {
	            return "Server";
	        } else {
	            return "Receiver";
	        }
	    }

	    public String getWinner() {
	        return winner;
	    }
		
	    @Override
	    public String getState() {
	        return "Won";
	    }
	    
	    @Override
	    public Tennis nextStateAfterServerWins() {
	    	return this;
	    }
	}
}
	}
