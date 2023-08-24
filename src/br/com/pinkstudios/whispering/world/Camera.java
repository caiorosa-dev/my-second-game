package br.com.pinkstudios.whispering.world;

public class Camera {

	private static int x = 0;
	private static int y = 0;
	
	public static int clamp(int current,int min,int max){
		if(current < min){
			current = min;
		}
		
		if(current > max) {
			current = max;
		}
		
		return current;
	}

	public static int getX() {
		return x;
	}

	public static int getY() {
		return y;
	}

	public static void setX(int x) {
		Camera.x = x;
	}

	public static void setY(int y) {
		Camera.y = y;
	}

}
