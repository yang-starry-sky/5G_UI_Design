//package com.myapplication.UIDesign.Utils;
//
//import com.myapplication.UIDesign.Database.Area;
//import com.myapplication.UIDesign.Database.BaseStation;
//import com.myapplication.UIDesign.Database.Equipment;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class DataUtility {
//
//    public static void addAreaData(){
//        List<Area> areas = new ArrayList<>();   //假装从服务器获得这个列表
//        //第一个，南京
//        Area area1 = new Area();
//        area1.setAreaTitle("南京EMBB");
//        area1.setModificationTime("2018-11-13 12:02:00");
//        area1.setCreator("admin");
//        area1.setDescription("南京EMBB");
//
//        area1.setDeviceOnline(210);
//        area1.setDeviceFailure(8);
//        area1.setBaseStationOnline(100);
//        area1.setBaseStationFailure(4);
//        area1.setBaseStationPlanning(30);
//        area1.setResourceUtilization1(85);
//        area1.setResourceUtilization2(72);
//        area1.setResourceUtilization3(65);
//        area1.setResourceUtilization4(42);
//        area1.setResourceUtilization5(15);
//
//        area1.save();
//        areas.add(area1);
//
//
//        //第二个，无锡
//        Area area2= new Area();
//        area2.setAreaTitle("无锡EMBB");
//        area2.setModificationTime("2018-11-13 12:02:00");
//        area2.setCreator("admin");
//        area2.setDescription("无锡EMBB");
//
//        area2.setDeviceOnline(210);
//        area2.setDeviceFailure(8);
//        area2.setBaseStationOnline(100);
//        area2.setBaseStationFailure(4);
//        area2.setBaseStationPlanning(30);
//        area2.setResourceUtilization1(85);
//        area2.setResourceUtilization2(72);
//        area2.setResourceUtilization3(65);
//        area2.setResourceUtilization4(42);
//        area2.setResourceUtilization5(15);
//
//        area2.save();
//        areas.add(area2);
//
//        //第三个，扬州
//        Area area3= new Area();
//        area3.setAreaTitle("扬州EMBB");
//        area3.setModificationTime("2018-11-13 12:02:00");
//        area3.setCreator("admin");
//        area3.setDescription("扬州EMBB");
//
//        area3.setDeviceOnline(210);
//        area3.setDeviceFailure(8);
//        area3.setBaseStationOnline(100);
//        area3.setBaseStationFailure(4);
//        area3.setBaseStationPlanning(30);
//        area3.setResourceUtilization1(85);
//        area3.setResourceUtilization2(72);
//        area3.setResourceUtilization3(65);
//        area3.setResourceUtilization4(42);
//        area3.setResourceUtilization5(15);
//
//        area3.save();
//        areas.add(area3);
//
//        //第四个，上海
//        Area area4= new Area();
//        area4.setAreaTitle("上海EMBB");
//        area4.setModificationTime("2018-11-13 12:02:00");
//        area4.setCreator("admin");
//        area4.setDescription("上海EMBB");
//
//        area4.setDeviceOnline(210);
//        area4.setDeviceFailure(8);
//        area4.setBaseStationOnline(100);
//        area4.setBaseStationFailure(4);
//        area4.setBaseStationPlanning(30);
//        area4.setResourceUtilization1(85);
//        area4.setResourceUtilization2(72);
//        area4.setResourceUtilization3(65);
//        area4.setResourceUtilization4(42);
//        area4.setResourceUtilization5(15);
//
//        area4.save();
//        areas.add(area4);
//
//        //第五个，北京
//        Area area5= new Area();
//        area5.setAreaTitle("北京EMBB");
//        area5.setModificationTime("2018-11-13 12:02:00");
//        area5.setCreator("admin");
//        area5.setDescription("北京EMBB");
//
//        area5.setDeviceOnline(210);
//        area5.setDeviceFailure(8);
//        area5.setBaseStationOnline(100);
//        area5.setBaseStationFailure(4);
//        area5.setBaseStationPlanning(30);
//        area5.setResourceUtilization1(85);
//        area5.setResourceUtilization2(72);
//        area5.setResourceUtilization3(65);
//        area5.setResourceUtilization4(42);
//        area5.setResourceUtilization5(15);
//
//        area5.save();
//        areas.add(area5);
//
//
//        //将从服务器获取到的area数据添加到安卓数据库中
//
//    }
//
//    public static void addBaseStationData(){
//
//        List<BaseStation> baseStations = new ArrayList<>();
//
//        //第一个
//        BaseStation baseStation1 = new BaseStation();
//        baseStation1.setAddress("CentralPark-Ring1-gNodeB1");
//        baseStation1.setDeploymentStatus("上线状态   Failure");
//        baseStation1.setOperatingStatus("运行状态   Normal");
//        baseStation1.setTime("上线时间   2020-04-12 20:55:21");
//        baseStation1.setType("gNodeB");
//        baseStation1.setCity("南京EMBB");
//        baseStation1.setCommunity("雨花台区");
//        baseStation1.setUNIInterface("ETH 2/3/4");
//        baseStation1.setRemarks("xxxxxxxxxxxxxxxx");
//        baseStation1.setVpnName("eMBB");
//
//        baseStation1.save();
//        baseStations.add(baseStation1);
//
//        //第二个
//        BaseStation baseStation2 = new BaseStation();
//        baseStation2.setAddress("CentralPark-Ring1-gNodeB2");
//        baseStation2.setDeploymentStatus("上线状态   Failure");
//        baseStation2.setOperatingStatus("运行状态   Normal");
//        baseStation2.setTime("上线时间   2020-04-12 20:55:21");
//        baseStation2.setType("gNodeB");
//        baseStation2.setCity("南京EMBB");
//        baseStation2.setCommunity("雨花台区");
//        baseStation2.setUNIInterface("ETH 2/3/4");
//        baseStation2.setRemarks("xxxxxxxxxxxxxxxx");
//        baseStation2.setVpnName("eMBB");
//
//        baseStation2.save();
//        baseStations.add(baseStation2);
//
//        //第三个
//        BaseStation baseStation3 = new BaseStation();
//        baseStation3.setAddress("CentralPark-Ring1-gNodeB3");
//        baseStation3.setDeploymentStatus("上线状态   Failure");
//        baseStation3.setOperatingStatus("运行状态   Normal");
//        baseStation3.setTime("上线时间   2020-04-12 20:55:21");
//        baseStation3.setType("gNodeB");
//        baseStation3.setCity("南京EMBB");
//        baseStation3.setCommunity("雨花台区");
//        baseStation3.setUNIInterface("ETH 2/3/4");
//        baseStation3.setRemarks("xxxxxxxxxxxxxxxx");
//        baseStation3.setVpnName("eMBB");
//
//        baseStation3.save();
//        baseStations.add(baseStation3);
//
//        //第四个
//        BaseStation baseStation4 = new BaseStation();
//        baseStation4.setAddress("CentralPark-Ring1-gNodeB4");
//        baseStation4.setDeploymentStatus("上线状态   Failure");
//        baseStation4.setOperatingStatus("运行状态   Normal");
//        baseStation4.setTime("上线时间   2020-04-12 20:55:21");
//        baseStation4.setType("gNodeB");
//        baseStation4.setCity("南京EMBB");
//        baseStation4.setCommunity("雨花台区");
//        baseStation4.setUNIInterface("ETH 2/3/4");
//        baseStation4.setRemarks("xxxxxxxxxxxxxxxx");
//        baseStation4.setVpnName("eMBB");
//
//        baseStation4.save();
//        baseStations.add(baseStation4);
//
//        //第五个
//        BaseStation baseStation5 = new BaseStation();
//        baseStation5.setAddress("CentralPark-Ring1-gNodeB5");
//        baseStation5.setDeploymentStatus("上线状态   Failure");
//        baseStation5.setOperatingStatus("运行状态   Normal");
//        baseStation5.setTime("上线时间   2020-04-12 20:55:21");
//        baseStation5.setType("gNodeB");
//        baseStation5.setCity("南京EMBB");
//        baseStation5.setCommunity("雨花台区");
//        baseStation5.setUNIInterface("ETH 2/3/4");
//        baseStation5.setRemarks("xxxxxxxxxxxxxxxx");
//        baseStation5.setVpnName("eMBB");
//
//        baseStation5.save();
//        baseStations.add(baseStation5);
//
//        //第六个
//        BaseStation baseStation6 = new BaseStation();
//        baseStation6.setAddress("CentralPark-Ring1-gNodeB6");
//        baseStation6.setDeploymentStatus("上线状态   Failure");
//        baseStation6.setOperatingStatus("运行状态   Normal");
//        baseStation6.setTime("上线时间   2020-04-12 20:55:21");
//        baseStation6.setType("gNodeB");
//        baseStation6.setCity("南京EMBB");
//        baseStation6.setCommunity("雨花台区");
//        baseStation6.setUNIInterface("ETH 2/3/4");
//        baseStation6.setRemarks("xxxxxxxxxxxxxxxx");
//        baseStation6.setVpnName("eMBB");
//
//        baseStation6.save();
//        baseStations.add(baseStation6);
//    }
//
//    public static void addEquipmentData(){
//        List<Equipment> equipments = new ArrayList<>();
//
//        //第一个
//        Equipment equipment1 = new Equipment();
//        equipment1.setName("ConcertHall-Ring1-CSG1");
//        equipment1.setOnlineStatus("上线状态   Failure");
//        equipment1.setOperatingStatus("运行状态   Normal");
//        equipment1.setTime("上线时间   2020-04-12 20:55:21");
//        equipment1.setCity("南京EMBB");
//        equipment1.setCommunity("雨花台区");
//        equipment1.setRemarks("xxxxxxxxxxxxxxxx");
//        equipment1.setUNIInterface("ETH 2/3/4");
//        equipment1.setVpnName("eMBB");
//        equipment1.setType("gNodeB");
//
//        equipment1.save();
//        equipments.add(equipment1);
//
//        //第二个
//        Equipment equipment2 = new Equipment();
//        equipment2.setName("ConcertHall-Ring1-CSG2");
//        equipment2.setOnlineStatus("上线状态   Failure");
//        equipment2.setOperatingStatus("运行状态   Normal");
//        equipment2.setTime("上线时间   2020-04-12 20:55:21");
//        equipment2.setCity("南京EMBB");
//        equipment2.setCommunity("雨花台区");
//        equipment2.setRemarks("xxxxxxxxxxxxxxxx");
//        equipment2.setUNIInterface("ETH 2/3/4");
//        equipment2.setVpnName("eMBB");
//        equipment2.setType("gNodeB");
//
//        equipment2.save();
//        equipments.add(equipment2);
//
//        //第三个
//        Equipment equipment3 = new Equipment();
//        equipment3.setName("ConcertHall-Ring1-CSG3");
//        equipment3.setOnlineStatus("上线状态   Failure");
//        equipment3.setOperatingStatus("运行状态   Normal");
//        equipment3.setTime("上线时间   2020-04-12 20:55:21");
//        equipment3.setCity("南京EMBB");
//        equipment3.setCommunity("雨花台区");
//        equipment3.setRemarks("xxxxxxxxxxxxxxxx");
//        equipment3.setUNIInterface("ETH 2/3/4");
//        equipment3.setVpnName("eMBB");
//        equipment3.setType("gNodeB");
//
//        equipment3.save();
//        equipments.add(equipment3);
//
//        //第四个
//        Equipment equipment4 = new Equipment();
//        equipment4.setName("ConcertHall-Ring1-CSG4");
//        equipment4.setOnlineStatus("上线状态   Failure");
//        equipment4.setOperatingStatus("运行状态   Normal");
//        equipment4.setTime("上线时间   2020-04-12 20:55:21");
//        equipment4.setCity("南京EMBB");
//        equipment4.setCommunity("雨花台区");
//        equipment4.setRemarks("xxxxxxxxxxxxxxxx");
//        equipment4.setUNIInterface("ETH 2/3/4");
//        equipment4.setVpnName("eMBB");
//        equipment4.setType("gNodeB");
//
//        equipment4.save();
//        equipments.add(equipment4);
//
//        //第五个
//        Equipment equipment5 = new Equipment();
//        equipment5.setName("ConcertHall-Ring1-CSG5");
//        equipment5.setOnlineStatus("上线状态   Failure");
//        equipment5.setOperatingStatus("运行状态   Normal");
//        equipment5.setTime("上线时间   2020-04-12 20:55:21");
//        equipment5.setCity("南京EMBB");
//        equipment5.setCommunity("雨花台区");
//        equipment5.setRemarks("xxxxxxxxxxxxxxxx");
//        equipment5.setUNIInterface("ETH 2/3/4");
//        equipment5.setVpnName("eMBB");
//        equipment5.setType("gNodeB");
//
//        equipment5.save();
//        equipments.add(equipment5);
//
//        //第六个
//        Equipment equipment6 = new Equipment();
//        equipment6.setName("ConcertHall-Ring1-CSG6");
//        equipment6.setOnlineStatus("上线状态   Failure");
//        equipment6.setOperatingStatus("运行状态   Normal");
//        equipment6.setTime("上线时间   2020-04-12 20:55:21");
//        equipment6.setCity("南京EMBB");
//        equipment6.setCommunity("雨花台区");
//        equipment6.setRemarks("xxxxxxxxxxxxxxxx");
//        equipment6.setUNIInterface("ETH 2/3/4");
//        equipment6.setVpnName("eMBB");
//        equipment6.setType("gNodeB");
//
//        equipment6.save();
//        equipments.add(equipment6);
//
//
//    }
//}
