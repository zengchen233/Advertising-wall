package zengchen233.cn;

/**
 * @class: AdvertisingBoard
 * @author: Zc
 * @Date: 2021/03/18 22:06
 * Description: 封装若干个广告.
 */
public class AdvertisingBoard {     //广告牌
    //数组advertisement的每一个单元存放一个广告(一个Advertisement对象)
    private Advertisement [] advertisement = null;  //用类Advertisement创建一个数组advertisement
    int index = -1;

    public void setAdvertisement(Advertisement[] advertisement) {
        this.advertisement = advertisement;
    }

    public Advertisement getAdvertisement(int i) {
        if (advertisement == null){
            return null;
        }
        if (advertisement.length == 0) {
            return null;
        }
        if (i >= advertisement.length || i < 0){
            return null;
        }
        return advertisement[i];
    }

    public Advertisement nextAdvertisement() {
        index++;
        if (advertisement == null) {
            return null;
        }
        if (advertisement.length == 0) {
            return null;
        }
        if (index == advertisement.length) {
            index = 0;
        }
        return advertisement[index];
    }

    public Advertisement previousAdvertisement() {
        index--;
        if (advertisement == null) {
            return null;
        }
        if (advertisement.length == 0) {
            return null;
        }
        if (index < 0) {
            index = advertisement.length - 1;
        }
        return advertisement[index];
    }
}
