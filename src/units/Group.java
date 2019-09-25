package units;

public class Group {
	private int value;
	public static boolean onlyShowFinalA = false, onlyShowFinalB = false, onlyShowFinalC = false;
	public static boolean combinedWavesA = false, combinedWavesB = false, combinedWavesC = false;
			
	
	public Group(int value){
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public static boolean isOnlyShowFinalA() {
		return onlyShowFinalA;
	}

	public static void setOnlyShowFinalA(boolean onlyShowFinalA) {
		Group.onlyShowFinalA = onlyShowFinalA;
	}

	public static boolean isOnlyShowFinalB() {
		return onlyShowFinalB;
	}

	public static void setOnlyShowFinalB(boolean onlyShowFinalB) {
		Group.onlyShowFinalB = onlyShowFinalB;
	}

	public static boolean isOnlyShowFinalC() {
		return onlyShowFinalC;
	}

	public static void setOnlyShowFinalC(boolean onlyShowFinalC) {
		Group.onlyShowFinalC = onlyShowFinalC;
	}

	public static boolean isCombinedWavesA() {
		return combinedWavesA;
	}

	public static void setCombinedWavesA(boolean combinedWavesA) {
		Group.combinedWavesA = combinedWavesA;
	}

	public static boolean isCombinedWavesB() {
		return combinedWavesB;
	}

	public static void setCombinedWavesB(boolean combinedWavesB) {
		Group.combinedWavesB = combinedWavesB;
	}

	public static boolean isCombinedWavesC() {
		return combinedWavesC;
	}

	public static void setCombinedWavesC(boolean combinedWavesC) {
		Group.combinedWavesC = combinedWavesC;
	}

	
	
	


}
