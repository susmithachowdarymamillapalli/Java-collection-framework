import java.util.EnumMap;

public class EnumMapDemo {
    public static void main(String[] args) {

        EnumMap<DAY, String> schedule = new EnumMap<>(DAY.class);
        schedule.put(DAY.MONDAY, "WFO");
        schedule.put(DAY.TUESDAY, "WFH");
        schedule.put(DAY.WEDNESDAY, "WALK");
        schedule.put(DAY.THURSDAY, "REST");
        schedule.put(DAY.FRIDAY, "GYM");
        schedule.put(DAY.SATURDAY, "RELAX");

        //null as value is allowed
        schedule.put(DAY.SUNDAY, null);

        //null key is not allowed
        try{
            schedule.put(null,null);
        }catch(Exception e){
            System.out.println(e);
        }

        //print the ordinal of key TUESDAY in the enum which is 1
        System.out.println("The ordinal of key TUESDAY: " + DAY.TUESDAY.ordinal());

        //map will be printed in the order they are present in the enum
        System.out.println(schedule);
    }
}

enum DAY{
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
};

/*
output:
-----------------------------------------------------------------------------
java.lang.NullPointerException: Cannot invoke "Object.getClass()" because "key" is null
The ordinal of key TUESDAY: 1
{MONDAY=WFO, TUESDAY=WFH, WEDNESDAY=WALK, THURSDAY=REST, FRIDAY=GYM, SATURDAY=RELAX, SUNDAY=null}
 */