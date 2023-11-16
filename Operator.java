
public class Operator {
    int action;

    public Operator() {

    }

    public Operator(int a) {
        this.action = a;
    }

    public void setAction(int a) {
        this.action = a;
    }

    public int getAction() {
        return this.action;
    }

    public static boolean checkStateNull(State s) {
        return s.data == null;
    }

    public State swap(State s) {
        int sz = 3;
        State sClone = s.clone();
        int x_new = s.findPos().get("posX");
        int y_new = s.findPos().get("posY");

        // Move up
        if (this.action == 0) {
            x_new -= 1;
        }
        // Move down
        else if (this.action == 1) {
            x_new += 1;
        }
        // Move left
        else if (this.action == 2) {
            y_new -= 1;
        }
        // Move right
        else {
            y_new += 1;
        }
        sClone.data[s.findPos().get("posX") * sz + s.findPos().get("posY")] = s.data[x_new * sz + y_new];
        sClone.data[x_new * sz + y_new] = "0";
        return sClone;
    }

    public State moveUp(State s) {
        if (this.checkStateNull(s))
            return null;
        else {
            int x = s.findPos().get("posX");
            if (x == 0) {
                return null;
            } else {
                return this.swap(s);
            }
        }
    }

    public State moveDown(State s) {
        if (this.checkStateNull(s))
            return null;
        else {
            int x = s.findPos().get("posX");
            if (x == 2) {
                return null;
            } else {
                return this.swap(s);
            }
        }
    }
    
    public State moveLeft(State s) {
        if (this.checkStateNull(s))
            return null;
        else {
            int y = s.findPos().get("posY");
            if (y == 0) {
                return null;
            } else {
                return this.swap(s);
            }
        }
    }
    
    public State moveRight(State s) {
        if (this.checkStateNull(s))
            return null;
        else {
            int y = s.findPos().get("posY");
            if (y == 2) {
                return null;
            } else {
                return this.swap(s);
            }
        }
    }

    public State letsMove(State s) {
        if (this.action == 0) {
            return this.moveUp(s);
        } else if (this.action == 1) {
            return this.moveDown(s);
        } else if (this.action == 2) {
            return this.moveLeft(s);
        } else if (this.action == 3) {
            return this.moveRight(s);
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        String[] data = { "1", "2", "3", "0", "4", "5", "6", "7", "8" };
        State a = new State();
        a.setData(data);

        Operator o = new Operator(2);

        System.out.println("State before swap: ");
        a.printMatrix();
        a = o.letsMove(a);

        if (a == null) {
            System.out.println("Khong the tao buoc nhay");
        } else {
            System.out.println("State after swap: ");
            a.printMatrix();
        }

        // System.out.println(checkStateNull(a));
        // a.printMatrix();
        // System.out.println(a.findPos().get("posX"));
        // System.out.println(a.findPos().get("posY"));

    }

}
