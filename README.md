# MovieMania

//Разработать виртуальную JVM
//
//        Разработать виртуальную JVM, удовлетворяющую следующим условиям:
//
//        1) Она имеет фиксированный размер памяти
//        2) Она может выделять пользователю по запросу область памяти, не превышающую по размеру свободную непрерывную память.
//        3) Пользователь может пометить выделенную область памяти как неиспользованную.
//        4) В случае, если объем свободной памяти меньше некоторого показателя(который задается при создании JVM), запускается сборщик мусора.
//        5) Сборщик мусора берет неиспользуемую память и перемещает в область свободной памяти, начиная с самых позднее выделенных областей памяти.
//        6) В этой задаче многопоточность не использовать
//



public class JVM
{
    public static int totalMemory;
    public static int usedMemory;
    public static int unsedMemory;
    public int dataUnit;
    
    public int[][]huy = new int[2][totalMemory];


    boolean [] jvmMemorySpace = new boolean[totalMemory];

    public int[] findFreeMemory(int memory){
        int firstPosition = 0;
        int lastPosition = 0;
        int capacity = 0;
        for (int i = 0; i < jvmMemorySpace.length; i++)
        {
            if(capacity < memory){
                if (jvmMemorySpace[i] = true){
                    capacity++;
                }
                if(jvmMemorySpace[i] = false){
                    capacity = 0;
                }
            }
            if(capacity == memory){
                lastPosition = i;
                firstPosition = lastPosition - capacity + 1;
                int[] positions = {firstPosition, lastPosition};
                return positions;
            }
        }
        int[] wrongpositions = {-1, -1};
        return wrongpositions;
    }

    public void requestMemory (int memory){
        if(memory < 1){
            System.out.println("You enter wrong data");
        }
        else{
            
          if( ){

          }
          if(memory > unsedMemory){
            System.out.println("We have no space for this operation");
          }
        }
    }

    public int[] checkedUnusedMemory(int[] position, int[] data){
        int[] newData = new int[totalMemory];

    }




}
