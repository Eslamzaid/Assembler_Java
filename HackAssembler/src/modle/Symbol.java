package modle;

public class Symbol {
    private String name;
    private int address;

    public Symbol(String name, int address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(int address) {
        this.address = address;
    }
}
