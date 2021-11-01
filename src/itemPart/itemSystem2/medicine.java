package itemPart.itemSystem2;
import itemPart.characterSystem.person;

//只实现迷路，内八，结石，熬夜，乌贼人5个负面状态
//对应的药就是利萨斯的旅行方法，绿茶（这个有点不太全年龄段，建议改为萤火虫），闪跳君，稀稀糊糊全治疗
//按状态命名的，分别是迷路，随机移动，持续掉血，攻击不中，致盲
//
public class medicine extends oneTimeItem{
    private boolean getLost;
    private boolean randomMove;
    private boolean bleed;
    private boolean miss;
    private boolean blind;


    public medicine(String url,   int price,int heal, boolean getLost, boolean randomMove, boolean bleed, boolean miss, boolean blind) {
        super(url,price ,heal);
        this.getLost = getLost;
        this.randomMove = randomMove;
        this.bleed = bleed;
        this.miss = miss;
        this.blind = blind;
    }

    @Override
    public String getUrl() {
        return super.getUrl();
    }
    @Override
    public int getHeal() {
        return super.getHeal();
    }
    @Override
    public int getPrice() {
        return super.getPrice();
    }

    public void treat(person person1) {
        if(getLost) person1.setBlind(getLost);
        if(randomMove) person1.setBlind(randomMove);
        if (bleed) person1.setBlind(bleed);
        if (miss) person1.setBlind(miss);
        if (blind) person1.setBlind(blind);
    }
}
