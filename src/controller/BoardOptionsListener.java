package controller;

public class BoardOptionsListener {
	
	public void setBoardValues(int numRows, int numCols, int[] treasureRows, int[] treasureCols) {
		
		BoardBuilder builder = new BoardBuilder();
		builder.setRows(numRows);
		builder.setCols(numCols);
		builder.initBoard();
		builder.setTreasureSites(treasureRows, treasureCols);
		builder.setStart();
		
	}

}
