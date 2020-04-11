package website.lhc.lspace.oss.qiniu;

import website.lhc.lspace.commo.base.AbstractToString;

/**
 * @ProjectName: l-space
 * @Package: website.lhc.lspace.oss.qiniu
 * @ClassName: CallBackBody
 * @Author: lhc
 * @Description: 七牛云回调参数集
 * @Date: 2020/4/11 下午 04:00
 */
public class CallBackBody extends AbstractToString {

    /**
     * 获得上传的目标空间名。
     */
    private String bucket;
    /**
     * 获得文件保存在空间中的资源名。
     */
    private String key;
    /**
     * 文件上传成功后的 HTTPETag。若上传时未指定资源ID，Etag将作为资源ID使用。
     */
    private String etag;
    /**
     * 上传的原始文件名。
     */
    private String fname;
    /**
     * 资源尺寸，单位为字节。
     */
    private Integer fsize;
    /**
     *
     */
    private String mimeType;
    /**
     * 上传时的年份。
     */
    private Integer year;
    /**
     * 上传时的日期。
     */
    private Integer mon;
    /**
     * 上传时的日期。
     */
    private Integer day;
    /**
     * 上传时的小时。。
     */
    private Integer hour;
    /**
     * 上传时的分钟。
     */
    private Integer min;
    /**
     * 自定义变量： 用户账号
     */
    private String account;

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public Integer getFsize() {
        return fsize;
    }

    public void setFsize(Integer fsize) {
        this.fsize = fsize;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMon() {
        return mon;
    }

    public void setMon(Integer mon) {
        this.mon = mon;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
