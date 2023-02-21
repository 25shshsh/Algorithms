package hashcode;

public class Record { // 사용자 정의 클래스 예시
    private static String name;
    private static int id;
    private static double value;

    public static void main(String[] args) {
        Record record = new Record();
        record.setRecordName("asd");
        record.setRecordId(55);
        record.setRecordValue(120);

        System.out.println(record.hashCode());
        record.setRecordId(56);
        System.out.println(record.hashCode());

    }
    public int hashCode() { // override하지 않으면 default함수가 사용된다면 나의 의도와 다르게 작동될수도
        int hash = 17; // nonzero constant

        hash = 31*hash + name.hashCode(); // String클래스 안 메서드
        hash = 31*hash + Integer.valueOf(id).hashCode(); // Integer 클래스 오버라이드
        hash = 31*hash + Double.valueOf(value).hashCode(); // Double 클래스 오버라이드

        return hash;
        // >> 클래스의 모든 멤버를 이용하여 해시코드를 만든다. (최대한 불규칙성을 규칙으로)
    }

    public void setRecordName (String name) {
        this.name= name;
    }

    public void setRecordId (int id) {
        this.id= id;
    }

    public void setRecordValue (double value) {
        this.value = value;
    }

    public static String getRecordName() {
        return name;
    }

    public static int getRecordId() {
        return id;
    }

    public static double getRecordValue() {
        return value;
    }
}
