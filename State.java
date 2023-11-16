import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class State {
    String[] data;
    String[] par;
    int Gx, Hx;
    int Fx;
    Operator op;
    // private static final int MAX = 100;

    public State() {

    }

    public State(String[] data) {
        this.data = data;
    }

    public State(String[] data, String[] par, int g, int h, int f) {
        this.data = data;
        this.par = par;
        this.Gx = g;
        this.Hx = h;
        this.Fx = f;
    }

    public State(String[] data, String[] par, int gx, int hx, int fx, Operator op) {
        this.data = data;
        this.par = par;
        Gx = gx;
        Hx = hx;
        Fx = fx;
        this.op = op;
    }

    public void setData(String[] data) {
        this.data = data;
    }

    public void setPar(String[] par) {
        this.par = par;
    }

    public void setGx(int gx) {
        Gx = gx;
    }

    public void setHx(int hx) {
        Hx = hx;
    }

    public void setFx(int fx) {
        Fx = fx;
    }

    public void setOp(Operator op) {
        this.op = op;
    }

    public Operator getOp() {
        return this.op;
    }

    public String[] getData() {
        return data;
    }

    public String[] getPar() {
        return par;
    }

    public int getGx() {
        return Gx;
    }

    public int getHx() {
        return Hx;
    }

    public int getFx() {
        return Fx;
    }

    // print matrix 3x3
    public void printMatrix() {
        int sz = 3;
        for (int i = 0; i < sz; i++) {
            for (int j = 0; j < sz; j++) {
                System.out.print(data[i * sz + j] + " ");
            }
            System.out.println();
        }
    }

    public State clone() {
        State s = new State();
        s.data = this.data;
        s.par = this.par;
        s.Gx = this.Gx;
        s.Hx = this.Hx;
        s.Fx = this.Fx;
        return s;
    }

    public Map<String, Integer> findPos() {
        int sz = 3;
        Map<String, Integer> pos = new HashMap<String, Integer>();
        for (int i = 0; i < sz; i++) {
            for (int j = 0; j < sz; j++) {
                if (this.data[i * sz + j] == "0") {
                    pos.put("posX", i);
                    pos.put("posY", j);
                    break;
                }
            }
            if (pos.size()==2) {
                break;
            }
        }
        return pos;
    }

    public StringBuilder Key() {
        StringBuilder flag = new StringBuilder("");
        if (this.data == null)
            return null;
        else {
            for (int i = 0; i < data.length; i++) {
                flag.append((String) data[i]);
            }
            return flag;
        }
    }

    public boolean lessThan(State b) {
        if (b == null)
            return false;
        else
            return this.Gx + this.Hx < b.Gx + b.Hx;
    }

    public boolean equal(State b) {
        if (b == null)
            return false;
        else
            return this.Key() == b.Key();
    }

    public static void main(String[] args) {
        // String data[] = new String[9];
        String data[] = { "1", "2", "3", "0", "4", "5", "6", "7", "8"};
        State a = new State(data);
        // a.setData(data);

        // System.out.println(a.data);
        // System.out.println(a.data.length);

        // if(a.data.length == 0)
        // System.out.println("dung");
        // else System.out.println("sai");

        a.printMatrix();
        System.out.println(a.Key());
        System.out.println(a.findPos().get("posX"));
        System.out.println(a.findPos().get("posY"));
    }

    

}
