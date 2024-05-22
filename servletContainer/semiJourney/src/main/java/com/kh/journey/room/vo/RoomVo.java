package com.kh.journey.room.vo;

public class RoomVo {
   private String no;
   private String accomNo;
   private String themeCode;
   private String name;
   private String capacity;
   private String grade;
   private String bathNum;
   private String roomNum;
   private String img01;
   private String img02;
   private String img03;
   private String img04;
   private String img05;
   private String enrollDate;
   private String modifyDate;
   private String exposeYn;
   private String delYn;
   private String bedSingle;
   private String bedDouble;
   private String bedQueen;
   private String weekdayPrice;
   private String weekendPrice;
   private String towelYn;
   private String tvYn;
   private String netflixYn;
   private String airconditionerYn;
   private String heatingYn;
   private String firealarmYn;
   private String firstaidkitYn;
   private String wifiYn;
   private String frigerYn;
   private String ovenYn;
   private String hairdryerYn;
   
   private String address;
   private String hostName;
   private String hostNo;
   private String hostPhone;
   private String hostProfile;
   private String themeName;
   
   // Constructor
   public RoomVo(String no, String accomNo, String themeCode, String name, String capacity, String grade,
         String bathNum, String roomNum, String img01, String img02, String img03, String img04, String img05,
         String enrollDate, String modifyDate, String exposeYn, String delYn, String bedSingle, String bedDouble,
         String bedQueen, String weekdayPrice, String weekendPrice, String towelYn, String tvYn, String netflixYn,
         String airconditionerYn, String heatingYn, String firealarmYn, String firstaidkitYn, String wifiYn,
         String frigerYn, String ovenYn, String hairdryerYn, String address, String hostName, String hostNo,
         String hostPhone, String hostProfile, String themeName) {
      this.no = no;
      this.accomNo = accomNo;
      this.themeCode = themeCode;
      this.name = name;
      this.capacity = capacity;
      this.grade = grade;
      this.bathNum = bathNum;
      this.roomNum = roomNum;
      this.img01 = img01;
      this.img02 = img02;
      this.img03 = img03;
      this.img04 = img04;
      this.img05 = img05;
      this.enrollDate = enrollDate;
      this.modifyDate = modifyDate;
      this.exposeYn = exposeYn;
      this.delYn = delYn;
      this.bedSingle = bedSingle;
      this.bedDouble = bedDouble;
      this.bedQueen = bedQueen;
      this.weekdayPrice = weekdayPrice;
      this.weekendPrice = weekendPrice;
      this.towelYn = towelYn;
      this.tvYn = tvYn;
      this.netflixYn = netflixYn;
      this.airconditionerYn = airconditionerYn;
      this.heatingYn = heatingYn;
      this.firealarmYn = firealarmYn;
      this.firstaidkitYn = firstaidkitYn;
      this.wifiYn = wifiYn;
      this.frigerYn = frigerYn;
      this.ovenYn = ovenYn;
      this.hairdryerYn = hairdryerYn;
      this.address = address;
      this.hostName = hostName;
      this.hostNo = hostNo;
      this.hostPhone = hostPhone;
      this.hostProfile = hostProfile;
      this.themeName = themeName;
   }
   public RoomVo() {
   }
   
   @Override
   public String toString() {
      return "RoomVo [no=" + no + ", accomNo=" + accomNo + ", themeCode=" + themeCode + ", name=" + name
            + ", capacity=" + capacity + ", grade=" + grade + ", bathNum=" + bathNum + ", roomNum=" + roomNum
            + ", img01=" + img01 + ", img02=" + img02 + ", img03=" + img03 + ", img04=" + img04 + ", img05=" + img05
            + ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + ", exposeYn=" + exposeYn + ", delYn="
            + delYn + ", bedSingle=" + bedSingle + ", bedDouble=" + bedDouble + ", bedQueen=" + bedQueen
            + ", weekdayPrice=" + weekdayPrice + ", weekendPrice=" + weekendPrice + ", towelYn=" + towelYn
            + ", tvYn=" + tvYn + ", netflixYn=" + netflixYn + ", airconditionerYn=" + airconditionerYn
            + ", heatingYn=" + heatingYn + ", firealarmYn=" + firealarmYn + ", firstaidkitYn=" + firstaidkitYn
            + ", wifiYn=" + wifiYn + ", frigerYn=" + frigerYn + ", ovenYn=" + ovenYn + ", hairdryerYn="
            + hairdryerYn + ", address=" + address + ", hostName=" + hostName + ", hostNo=" + hostNo
            + ", hostPhone=" + hostPhone + ", hostProfile=" + hostProfile + ", themeName=" + themeName + "]";
   }
   
   // Getter, Setter
   public String getNo() {
      return no;
   }
   public void setNo(String no) {
      this.no = no;
   }
   public String getAccomNo() {
      return accomNo;
   }
   public void setAccomNo(String accomNo) {
      this.accomNo = accomNo;
   }
   public String getThemeCode() {
      return themeCode;
   }
   public void setThemeCode(String themeCode) {
      this.themeCode = themeCode;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getCapacity() {
      return capacity;
   }
   public void setCapacity(String capacity) {
      this.capacity = capacity;
   }
   public String getGrade() {
      return grade;
   }
   public void setGrade(String grade) {
      this.grade = grade;
   }
   public String getBathNum() {
      return bathNum;
   }
   public void setBathNum(String bathNum) {
      this.bathNum = bathNum;
   }
   public String getRoomNum() {
      return roomNum;
   }
   public void setRoomNum(String roomNum) {
      this.roomNum = roomNum;
   }
   public String getImg01() {
      return img01;
   }
   public void setImg01(String img01) {
      this.img01 = img01;
   }
   public String getImg02() {
      return img02;
   }
   public void setImg02(String img02) {
      this.img02 = img02;
   }
   public String getImg03() {
      return img03;
   }
   public void setImg03(String img03) {
      this.img03 = img03;
   }
   public String getImg04() {
      return img04;
   }
   public void setImg04(String img04) {
      this.img04 = img04;
   }
   public String getImg05() {
      return img05;
   }
   public void setImg05(String img05) {
      this.img05 = img05;
   }
   public String getEnrollDate() {
      return enrollDate;
   }
   public void setEnrollDate(String enrollDate) {
      this.enrollDate = enrollDate;
   }
   public String getModifyDate() {
      return modifyDate;
   }
   public void setModifyDate(String modifyDate) {
      this.modifyDate = modifyDate;
   }
   public String getExposeYn() {
      return exposeYn;
   }
   public void setExposeYn(String exposeYn) {
      this.exposeYn = exposeYn;
   }
   public String getDelYn() {
      return delYn;
   }
   public void setDelYn(String delYn) {
      this.delYn = delYn;
   }
   public String getBedSingle() {
      return bedSingle;
   }
   public void setBedSingle(String bedSingle) {
      this.bedSingle = bedSingle;
   }
   public String getBedDouble() {
      return bedDouble;
   }
   public void setBedDouble(String bedDouble) {
      this.bedDouble = bedDouble;
   }
   public String getBedQueen() {
      return bedQueen;
   }
   public void setBedQueen(String bedQueen) {
      this.bedQueen = bedQueen;
   }
   public String getWeekdayPrice() {
      return weekdayPrice;
   }
   public void setWeekdayPrice(String weekdayPrice) {
      this.weekdayPrice = weekdayPrice;
   }
   public String getWeekendPrice() {
      return weekendPrice;
   }
   public void setWeekendPrice(String weekendPrice) {
      this.weekendPrice = weekendPrice;
   }
   public String getTowelYn() {
      return towelYn;
   }
   public void setTowelYn(String towelYn) {
      this.towelYn = towelYn;
   }
   public String getTvYn() {
      return tvYn;
   }
   public void setTvYn(String tvYn) {
      this.tvYn = tvYn;
   }
   public String getNetflixYn() {
      return netflixYn;
   }
   public void setNetflixYn(String netflixYn) {
      this.netflixYn = netflixYn;
   }
   public String getAirconditionerYn() {
      return airconditionerYn;
   }
   public void setAirconditionerYn(String airconditionerYn) {
      this.airconditionerYn = airconditionerYn;
   }
   public String getHeatingYn() {
      return heatingYn;
   }
   public void setHeatingYn(String heatingYn) {
      this.heatingYn = heatingYn;
   }
   public String getFirealarmYn() {
      return firealarmYn;
   }
   public void setFirealarmYn(String firealarmYn) {
      this.firealarmYn = firealarmYn;
   }
   public String getFirstaidkitYn() {
      return firstaidkitYn;
   }
   public void setFirstaidkitYn(String firstaidkitYn) {
      this.firstaidkitYn = firstaidkitYn;
   }
   public String getWifiYn() {
      return wifiYn;
   }
   public void setWifiYn(String wifiYn) {
      this.wifiYn = wifiYn;
   }
   public String getFrigerYn() {
      return frigerYn;
   }
   public void setFrigerYn(String frigerYn) {
      this.frigerYn = frigerYn;
   }
   public String getOvenYn() {
      return ovenYn;
   }
   public void setOvenYn(String ovenYn) {
      this.ovenYn = ovenYn;
   }
   public String getHairdryerYn() {
      return hairdryerYn;
   }
   public void setHairdryerYn(String hairdryerYn) {
      this.hairdryerYn = hairdryerYn;
   }
   public String getAddress() {
      return address;
   }
   public void setAddress(String address) {
      this.address = address;
   }
   public String getHostName() {
      return hostName;
   }
   public void setHostName(String hostName) {
      this.hostName = hostName;
   }
   public String getHostNo() {
      return hostNo;
   }
   public void setHostNo(String hostNo) {
      this.hostNo = hostNo;
   }
   public String getHostPhone() {
      return hostPhone;
   }
   public void setHostPhone(String hostPhone) {
      this.hostPhone = hostPhone;
   }
   public String getHostProfile() {
      return hostProfile;
   }
   public void setHostProfile(String hostProfile) {
      this.hostProfile = hostProfile;
   }
   public String getThemeName() {
      return themeName;
   }
   public void setThemeName(String themeName) {
      this.themeName = themeName;
   }
}