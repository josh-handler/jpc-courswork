public class Location {

	private int row;
	private int column;

	public Location(int column, int row) {
		this.row = row;
		this.column = column;
	}

	//checks whether current location matches goven location
	public boolean locationMatch(Location location) {
		// if (this.row == location.getRow()) && (this.column == location.getColumn()) {
		// 	return true;
		// }
		return (this.row == location.getRow()) && (this.column == location.getColumn());
	}

	//cqlculate distance to location from current location
	public final int calculateDistance(Location location) {
		//positive so abs, wanted location - current location
		int rows = Math.abs(this.getRow() - location.getRow());
		int columns = Math.abs(this.getColumn() - location.getColumn());

		return rows + columns;
	}

	//getters

	public int getRow() {
		return this.row;
	}

	public int getColumn() {
		return this.column;
	}
