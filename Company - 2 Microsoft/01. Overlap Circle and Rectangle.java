// Link : https://leetcode.com/problems/circle-and-rectangle-overlapping/

public class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        // Calculate the  point (x, y) in the rectangle to the center of the circle
        int X = Math.max(x1, Math.min(xCenter, x2));
        int Y = Math.max(y1, Math.min(yCenter, y2));

        // Calculate the squared distance between the center of the circle and the  point in the rectangle
        int dist = (xCenter - X) * (xCenter - X) + (yCenter - Y) * (yCenter - Y);

        // Check if the squared distance is less than or equal to the square of the radius
        return dist <= radius * radius;
    }
}
