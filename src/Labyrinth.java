public class Labyrinth
{
    private Point p;
    private final int lHeight, lWidth;
    private final int[] sPoint, fPoint;
    private final char[][] labyrinth;
    public Labyrinth(char[][] matrix, int[] s, int[] f) throws Exception {
        if(matrix.length <= 1) throw new Exception("Exception");

        labyrinth = matrix;
        lHeight = labyrinth.length;
        lWidth = labyrinth[0].length;

        sPoint = s;
        fPoint = f;

        labyrinth[sPoint[1]][sPoint[0]] = 'S';
        labyrinth[fPoint[1]][fPoint[0]] = 'F';
    }
    public static class Point{
        private final int x, y;
        private final Point parent;
        public Point(int x, int y, Point parent) {
            this.x = x;
            this.y = y;
            this.parent = parent;
        }
        public Point getParent() {
            return parent;
        }
    }
    public boolean isCorrectPoint(int x, int y){
        return x >= 0 && x < lWidth && y >= 0 && y < lHeight && labyrinth[y][x] != '#';
    }
    public void getPath() {
        Queue<Point> queue = new Queue<>();
        boolean[][] used = new boolean[labyrinth.length][labyrinth[0].length];
        queue.add(new Point(sPoint[0], sPoint[1], null));

        while (queue.size != 0) {
            Point point = queue.poll();
            used[point.y][point.x] = true;

            if(labyrinth[point.y][point.x] == labyrinth[fPoint[1]][fPoint[0]]) {
                p = point;
                break;
            }

            if(isCorrectPoint(point.x - 1, point.y) && !used[point.y][point.x - 1])
                queue.add(new Point(point.x - 1, point.y, point));

            if(isCorrectPoint(point.x + 1, point.y) && !used[point.y][point.x + 1])
                queue.add(new Point(point.x + 1, point.y, point));

            if(isCorrectPoint(point.x, point.y - 1) && !used[point.y - 1][point.x])
                queue.add(new Point(point.x, point.y - 1, point));

            if(isCorrectPoint(point.x , point.y + 1) && !used[point.y + 1][point.x])
                queue.add(new Point(point.x, point.y + 1, point));

            /*for(int y = -1; y <= 1; y++){
                for(int x = -1; x <= 1; x++){
                    if(isCorrectPoint(point.x - x, point.y - y) && !used[point.y - y][point.x - x])
                        queue.add(new Point(point.x - x, point.y - y, point));
                }
            }*/
        }
    }
    public void print(){
        System.out.println();
        for (char[] chars : labyrinth) {
            for (int j = 0; j < labyrinth[0].length; j++)
                System.out.print(chars[j] + " ");
            System.out.println();
        }
    }
    public void setPath() {
        while(p.getParent() != null) {
            p = p.getParent();
            if(labyrinth[p.y][p.x] != 'S')
                labyrinth[p.y][p.x] = 'X';
        }
    }
}

