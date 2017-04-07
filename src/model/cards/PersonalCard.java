package model.cards;

public class PersonalCard extends Card{
		
		private String type = "personal";
		protected String effect;
		
		public String getEffect() {
			return effect;
		}
		
		public String getType() {
			return type;
		}
}
