public class Client {
    private String name;
    private int member_id;
    private int age;

    public Client() {
    }

    public Client(String name, int age, int member_id) {
        this.name = name;
        this.member_id = member_id;
        this.age = age;
    }

    public boolean checkMembership(int member_id){
        return Integer.toString(member_id).startsWith("111");
    }

    public int getMember_id() {
        return member_id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
