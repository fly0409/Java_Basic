package EnumDemo;

/**
 * 過去實現枚舉的方法
 *
 */
class Season {
    //1.聲明season物件的屬性
    //由於該值為固定的不能改 要以final 修飾
    private final String seasonName;
    private final String seasonDesc;

    //2.私有建構子，物件賦值
    private Season(String seasonName,String seasonDesc){
        this.seasonName= seasonName;
        this.seasonDesc = seasonDesc;
    }
    //3.聲明枚舉類
    public final static Season SPRING = new Season("spring","春天");
    public final static Season SUMMER = new Season("summer","夏天");
    public final static Season AUTUMN = new Season("autumn","秋天");
    public final static Season WINTER = new Season("winter","冬天");

    //提供get
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
    //提供toString

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}



public class SeasonTest {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);   }



}


