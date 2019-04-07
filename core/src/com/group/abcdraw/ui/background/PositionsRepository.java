package com.group.abcdraw.ui.background;

import com.group.abcdraw.model.Position;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PositionsRepository {
    private static final PositionsRepository ourInstance = new PositionsRepository();

    public static PositionsRepository getInstance() {
        return ourInstance;
    }

    private PositionsRepository() {
    }

    public List<Position> getByLetter(char letter){
        List<Position> points = new ArrayList<Position>();
        switch (letter) {
            case 'a':
                points.add(new Position(912, 946));
                points.add(new Position(798, 950));
                points.add(new Position(694, 944));
                points.add(new Position(588, 917));
                points.add(new Position(464, 883));
                points.add(new Position(408, 816));
                points.add(new Position(358, 718));
                points.add(new Position(420, 637));
                points.add(new Position(528, 587));
                points.add(new Position(658, 582));
                points.add(new Position(798, 591));
                points.add(new Position(902, 642));
                points.add(new Position(1010, 706));
                points.add(new Position(1032, 798));
                points.add(new Position(1036, 897));
                points.add(new Position(1056, 957));
                points.add(new Position(1018, 600));
                break;
            case 'A':
                points.add(new Position(886, 399));
                points.add(new Position(246, 593));
                points.add(new Position(444, 936));
                points.add(new Position(717, 1249));
                points.add(new Position(944, 1000));
                points.add(new Position(1206, 605));
                points.add(new Position(1084, 828));
                points.add(new Position(425, 810));
                break;

            //b letter group
            case 'b':
                points.add(new Position(417, 1275));
                points.add(new Position(438, 873));
                points.add(new Position(425, 562));
                points.add(new Position(426, 985));
                points.add(new Position(764, 1066));
                points.add(new Position(1089, 966));
                points.add(new Position(1140, 742));
                points.add(new Position(889, 582));
                points.add(new Position(413, 609));
                break;
            case 'B':
                points.add(new Position(346, 1261));
                points.add(new Position(346, 1009));
                points.add(new Position(344, 803));
                points.add(new Position(346, 590));
                points.add(new Position(356, 1251));
                points.add(new Position(722, 1251));
                points.add(new Position(1022, 1188));
                points.add(new Position(977, 1033));
                points.add(new Position(744, 953));
                points.add(new Position(425, 950));
                points.add(new Position(870, 947));
                points.add(new Position(1104, 862));
                points.add(new Position(1124, 691));
                points.add(new Position(901, 595));
                points.add(new Position(333, 582));
                break;

            //c letter group
            case 'c':
                points.add(new Position(1020, 1022));
                points.add(new Position(689, 1048));
                points.add(new Position(445, 961));
                points.add(new Position(400, 758));
                points.add(new Position(530, 605));
                points.add(new Position(785, 546));
                points.add(new Position(1058, 599));
                break;
            case 'C':
                points.add(new Position(1156, 1221));
                points.add(new Position(728, 1271));
                points.add(new Position(360, 1163));
                points.add(new Position(265, 913));
                points.add(new Position(442, 647));
                points.add(new Position(760, 561));
                points.add(new Position(1161, 645));
                break;

            //d letter group
            case 'd':
                points.add(new Position(1092, 1266));
                points.add(new Position(1117, 919));
                points.add(new Position(1098, 579));
                points.add(new Position(1124, 1026));
                points.add(new Position(760, 1063));
                points.add(new Position(440, 974));
                points.add(new Position(393, 720));
                points.add(new Position(614, 570));
                points.add(new Position(914, 597));
                points.add(new Position(1146, 689));
                break;
            case 'D':
                points.add(new Position(265, 1264));
                points.add(new Position(269, 920));
                points.add(new Position(270, 595));
                points.add(new Position(334, 1248));
                points.add(new Position(837, 1240));
                points.add(new Position(1172, 1073));
                points.add(new Position(1189, 809));
                points.add(new Position(917, 629));
                points.add(new Position(589, 587));
                points.add(new Position(250, 583));
                break;

            //e letter group
            case 'e':
                points.add(new Position(376, 832));
                points.add(new Position(764, 842));
                points.add(new Position(1132, 835));
                points.add(new Position(1000, 1034));
                points.add(new Position(704, 1077));
                points.add(new Position(438, 979));
                points.add(new Position(358, 705));
                points.add(new Position(616, 582));
                points.add(new Position(989, 589));
                break;
            case 'E':
                points.add(new Position(1056, 1266));
                points.add(new Position(649, 1259));
                points.add(new Position(338, 1249));
                points.add(new Position(350, 952));
                points.add(new Position(630, 958));
                points.add(new Position(908, 957));
                points.add(new Position(356, 949));
                points.add(new Position(364, 762));
                points.add(new Position(364, 596));
                points.add(new Position(674, 589));
                points.add(new Position(1050, 603));
                break;

            //f letter group
            case 'f':
                points.add(new Position(1008, 1261));
                points.add(new Position(749, 1267));
                points.add(new Position(625, 1129));
                points.add(new Position(645, 905));
                points.add(new Position(646, 669));
                points.add(new Position(657, 557));
                points.add(new Position(664, 1042));
                points.add(new Position(485, 1050));
                points.add(new Position(933, 1046));
                break;
            case 'F':
                points.add(new Position(1076, 1234));
                points.add(new Position(748, 1255));
                points.add(new Position(410, 1251));
                points.add(new Position(386, 966));
                points.add(new Position(633, 958));
                points.add(new Position(1014, 956));
                points.add(new Position(393, 959));
                points.add(new Position(424, 800));
                points.add(new Position(425, 594));
                break;

            //g letter group
            case 'g':
                points.add(new Position(1046, 1028));
                points.add(new Position(697, 1070));
                points.add(new Position(398, 941));
                points.add(new Position(360, 737));
                points.add(new Position(544, 592));
                points.add(new Position(801, 584));
                points.add(new Position(1037, 658));
                points.add(new Position(1092, 795));
                points.add(new Position(1089, 1041));
                points.add(new Position(1116, 602));
                points.add(new Position(824, 351));
                points.add(new Position(524, 327));
                break;
            case 'G':
                points.add(new Position(1177, 1227));
                points.add(new Position(710, 1265));
                points.add(new Position(350, 1167));
                points.add(new Position(205, 937));
                points.add(new Position(340, 716));
                points.add(new Position(622, 591));
                points.add(new Position(957, 581));
                points.add(new Position(1190, 638));
                points.add(new Position(1237, 826));
                points.add(new Position(1234, 909));
                points.add(new Position(826, 890));
                break;

            //h letter group
            case 'h':
                points.add(new Position(381, 1249));
                points.add(new Position(378, 940));
                points.add(new Position(378, 570));
                points.add(new Position(430, 957));
                points.add(new Position(710, 1038));
                points.add(new Position(998, 1025));
                points.add(new Position(1092, 879));
                points.add(new Position(1069, 670));
                points.add(new Position(1062, 563));
                break;
            case 'H':
                points.add(new Position(293, 1252));
                points.add(new Position(328, 936));
                points.add(new Position(302, 574));
                points.add(new Position(328, 939));
                points.add(new Position(740, 958));
                points.add(new Position(1157, 953));
                points.add(new Position(1144, 1268));
                points.add(new Position(1161, 602));
                break;

            //i letter group
            case 'i':
                points.add(new Position(722, 1051));
                points.add(new Position(717, 829));
                points.add(new Position(738, 601));
                break;
            case 'I':
                points.add(new Position(501, 1259));
                points.add(new Position(917, 1255));
                points.add(new Position(708, 1265));
                points.add(new Position(726, 1015));
                points.add(new Position(717, 841));
                points.add(new Position(717, 596));
                points.add(new Position(504, 574));
                points.add(new Position(905, 588));
                break;

            //j letter group
            case 'j':
                points.add(new Position(952, 1049));
                points.add(new Position(937, 784));
                points.add(new Position(940, 568));
                points.add(new Position(753, 346));
                points.add(new Position(548, 344));
                break;
            case 'J':
                points.add(new Position(496, 1255));
                points.add(new Position(1156, 1267));
                points.add(new Position(828, 1265));
                points.add(new Position(853, 1116));
                points.add(new Position(850, 894));
                points.add(new Position(806, 715));
                points.add(new Position(697, 592));
                points.add(new Position(412, 590));
                break;

            //k letter group
            case 'k':
                points.add(new Position(373, 1287));
                points.add(new Position(390, 970));
                points.add(new Position(380, 731));
                points.add(new Position(385, 542));
                points.add(new Position(398, 748));
                points.add(new Position(1036, 1079));
                points.add(new Position(665, 880));
                points.add(new Position(816, 698));
                points.add(new Position(1057, 574));
                break;
            case 'K':
                points.add(new Position(302, 1240));
                points.add(new Position(320, 937));
                points.add(new Position(330, 597));
                points.add(new Position(329, 829));
                points.add(new Position(640, 984));
                points.add(new Position(933, 1148));
                points.add(new Position(1162, 1277));
                points.add(new Position(581, 948));
                points.add(new Position(729, 847));
                points.add(new Position(938, 705));
                points.add(new Position(1150, 586));
                break;

            //l letter group
            case 'l':
                points.add(new Position(708, 1263));
                points.add(new Position(744, 991));
                points.add(new Position(745, 804));
                points.add(new Position(756, 606));
                break;
            case 'L':
                points.add(new Position(386, 1253));
                points.add(new Position(388, 999));
                points.add(new Position(422, 777));
                points.add(new Position(401, 576));
                points.add(new Position(718, 590));
                points.add(new Position(1068, 599));
                break;

            //m letter group
            case 'm':
                points.add(new Position(181, 1044));
                points.add(new Position(194, 815));
                points.add(new Position(190, 588));
                points.add(new Position(181, 951));
                points.add(new Position(500, 1058));
                points.add(new Position(766, 996));
                points.add(new Position(749, 784));
                points.add(new Position(717, 584));
                points.add(new Position(722, 979));
                points.add(new Position(1020, 1053));
                points.add(new Position(1246, 1020));
                points.add(new Position(1262, 849));
                points.add(new Position(1254, 586));
                break;
            case 'M':
                points.add(new Position(228, 586));
                points.add(new Position(241, 887));
                points.add(new Position(232, 1249));
                points.add(new Position(498, 1112));
                points.add(new Position(724, 848));
                points.add(new Position(949, 1022));
                points.add(new Position(1196, 1274));
                points.add(new Position(1222, 949));
                points.add(new Position(1210, 634));
                break;

            //n letter group
            case 'n':
                points.add(new Position(346, 1061));
                points.add(new Position(397, 829));
                points.add(new Position(373, 574));
                points.add(new Position(368, 942));
                points.add(new Position(729, 1063));
                points.add(new Position(1040, 1010));
                points.add(new Position(1057, 772));
                points.add(new Position(1037, 580));
                break;
            case 'N':
                points.add(new Position(269, 602));
                points.add(new Position(265, 947));
                points.add(new Position(337, 1262));
                points.add(new Position(626, 1051));
                points.add(new Position(873, 809));
                points.add(new Position(1084, 600));
                points.add(new Position(1136, 872));
                points.add(new Position(1153, 1247));
                break;

            //o letter group
            case 'o':
                points.add(new Position(717, 1073));
                points.add(new Position(420, 982));
                points.add(new Position(368, 760));
                points.add(new Position(594, 568));
                points.add(new Position(897, 574));
                points.add(new Position(1128, 739));
                points.add(new Position(1109, 941));
                points.add(new Position(906, 1042));
                points.add(new Position(672, 1077));
                break;
            case 'O':
                points.add(new Position(733, 1282));
                points.add(new Position(321, 1168));
                points.add(new Position(188, 918));
                points.add(new Position(346, 661));
                points.add(new Position(665, 565));
                points.add(new Position(1006, 613));
                points.add(new Position(1202, 847));
                points.add(new Position(1249, 1058));
                points.add(new Position(1108, 1203));
                points.add(new Position(670, 1290));
                break;

            //p letter group
            case 'p':
                points.add(new Position(342, 1039));
                points.add(new Position(368, 765));
                points.add(new Position(354, 517));
                points.add(new Position(351, 338));
                points.add(new Position(372, 952));
                points.add(new Position(628, 1038));
                points.add(new Position(1004, 1042));
                points.add(new Position(1101, 885));
                points.add(new Position(1002, 666));
                points.add(new Position(797, 570));
                points.add(new Position(546, 587));
                points.add(new Position(342, 628));
                break;
            case 'P':
                points.add(new Position(368, 1254));
                points.add(new Position(400, 1018));
                points.add(new Position(396, 816));
                points.add(new Position(436, 597));
                points.add(new Position(428, 1258));
                points.add(new Position(701, 1247));
                points.add(new Position(1038, 1188));
                points.add(new Position(1086, 1014));
                points.add(new Position(930, 893));
                points.add(new Position(653, 865));
                points.add(new Position(373, 885));
                break;

            //q letter group
            case 'q':
                points.add(new Position(1060, 1053));
                points.add(new Position(1065, 846));
                points.add(new Position(1066, 603));
                points.add(new Position(1137, 375));
                points.add(new Position(1090, 1057));
                points.add(new Position(890, 1044));
                points.add(new Position(601, 1051));
                points.add(new Position(382, 909));
                points.add(new Position(388, 703));
                points.add(new Position(642, 592));
                points.add(new Position(938, 616));
                points.add(new Position(1126, 769));
                break;
            case 'Q':
                points.add(new Position(674, 1272));
                points.add(new Position(331, 1181));
                points.add(new Position(209, 967));
                points.add(new Position(274, 705));
                points.add(new Position(562, 586));
                points.add(new Position(820, 600));
                points.add(new Position(1000, 638));
                points.add(new Position(877, 711));
                points.add(new Position(1084, 542));
                points.add(new Position(1006, 631));
                points.add(new Position(1168, 715));
                points.add(new Position(1240, 911));
                points.add(new Position(1225, 1061));
                points.add(new Position(1052, 1210));
                points.add(new Position(822, 1275));
                points.add(new Position(613, 1266));
                break;

            //r letter group
            case 'r':
                points.add(new Position(448, 1059));
                points.add(new Position(494, 836));
                points.add(new Position(485, 583));
                points.add(new Position(486, 939));
                points.add(new Position(730, 1017));
                points.add(new Position(1028, 1052));
                break;
            case 'R':
                points.add(new Position(280, 1248));
                points.add(new Position(276, 954));
                points.add(new Position(276, 754));
                points.add(new Position(306, 553));
                points.add(new Position(310, 1249));
                points.add(new Position(610, 1253));
                points.add(new Position(897, 1215));
                points.add(new Position(980, 1050));
                points.add(new Position(809, 932));
                points.add(new Position(578, 901));
                points.add(new Position(320, 888));
                points.add(new Position(652, 894));
                points.add(new Position(868, 763));
                points.add(new Position(1109, 595));
                break;

            //s letter group
            case 's':
                points.add(new Position(973, 1021));
                points.add(new Position(656, 1066));
                points.add(new Position(405, 989));
                points.add(new Position(493, 829));
                points.add(new Position(796, 783));
                points.add(new Position(1022, 697));
                points.add(new Position(937, 579));
                points.add(new Position(633, 548));
                points.add(new Position(382, 607));
                break;
            case 'S':
                points.add(new Position(1152, 1201));
                points.add(new Position(766, 1258));
                points.add(new Position(460, 1247));
                points.add(new Position(282, 1078));
                points.add(new Position(617, 926));
                points.add(new Position(956, 888));
                points.add(new Position(1180, 787));
                points.add(new Position(1025, 611));
                points.add(new Position(696, 583));
                points.add(new Position(312, 616));
                break;

            //t letter group
            case 't':
                points.add(new Position(622, 1085));
                points.add(new Position(669, 874));
                points.add(new Position(676, 629));
                points.add(new Position(673, 946));
                points.add(new Position(370, 954));
                points.add(new Position(950, 948));
                break;
            case 'T':
                points.add(new Position(696, 1263));
                points.add(new Position(728, 989));
                points.add(new Position(720, 770));
                points.add(new Position(725, 580));
                points.add(new Position(732, 1257));
                points.add(new Position(485, 1253));
                points.add(new Position(181, 1253));
                points.add(new Position(742, 1255));
                points.add(new Position(1022, 1250));
                points.add(new Position(1233, 1261));
                break;

            //u letter group
            case 'u':
                points.add(new Position(368, 1071));
                points.add(new Position(390, 836));
                points.add(new Position(473, 631));
                points.add(new Position(772, 593));
                points.add(new Position(1026, 708));
                points.add(new Position(1054, 933));
                points.add(new Position(1030, 1131));
                points.add(new Position(1065, 592));
                break;
            case 'U':
                points.add(new Position(258, 1251));
                points.add(new Position(284, 1038));
                points.add(new Position(313, 761));
                points.add(new Position(474, 606));
                points.add(new Position(749, 580));
                points.add(new Position(1024, 622));
                points.add(new Position(1152, 804));
                points.add(new Position(1132, 973));
                points.add(new Position(1153, 1243));
                break;

            //v letter group
            case 'v':
                points.add(new Position(328, 1100));
                points.add(new Position(510, 874));
                points.add(new Position(718, 634));
                points.add(new Position(945, 870));
                points.add(new Position(1084, 1104));
                break;
            case 'V':
                points.add(new Position(229, 1269));
                points.add(new Position(414, 1004));
                points.add(new Position(573, 760));
                points.add(new Position(761, 594));
                points.add(new Position(969, 829));
                points.add(new Position(1085, 1033));
                points.add(new Position(1241, 1279));
                break;

            //w letter group
            case 'w':
                points.add(new Position(185, 1095));
                points.add(new Position(294, 840));
                points.add(new Position(426, 606));
                points.add(new Position(594, 874));
                points.add(new Position(724, 1103));
                points.add(new Position(901, 842));
                points.add(new Position(1026, 626));
                points.add(new Position(1138, 873));
                points.add(new Position(1238, 1094));
                break;
            case 'W':
                points.add(new Position(165, 1262));
                points.add(new Position(289, 979));
                points.add(new Position(351, 768));
                points.add(new Position(450, 600));
                points.add(new Position(568, 890));
                points.add(new Position(709, 1165));
                points.add(new Position(872, 927));
                points.add(new Position(989, 608));
                points.add(new Position(1125, 793));
                points.add(new Position(1198, 1044));
                points.add(new Position(1270, 1267));
                break;

            //x letter group
            case 'x':
                points.add(new Position(397, 1088));
                points.add(new Position(713, 888));
                points.add(new Position(1062, 601));
                points.add(new Position(725, 853));
                points.add(new Position(1077, 1104));
                points.add(new Position(718, 861));
                points.add(new Position(372, 609));
                break;
            case 'X':
                points.add(new Position(301, 1276));
                points.add(new Position(561, 1070));
                points.add(new Position(728, 922));
                points.add(new Position(928, 770));
                points.add(new Position(1156, 600));
                points.add(new Position(736, 914));
                points.add(new Position(968, 1090));
                points.add(new Position(1176, 1262));
                points.add(new Position(728, 911));
                points.add(new Position(529, 744));
                points.add(new Position(337, 580));
                break;

            //y letter group
            case 'y':
                points.add(new Position(377, 1101));
                points.add(new Position(544, 849));
                points.add(new Position(734, 648));
                points.add(new Position(978, 890));
                points.add(new Position(1120, 1118));
                points.add(new Position(733, 645));
                points.add(new Position(525, 339));
                break;
            case 'Y':
                points.add(new Position(262, 1268));
                points.add(new Position(481, 1092));
                points.add(new Position(717, 927));
                points.add(new Position(976, 1106));
                points.add(new Position(1153, 1261));
                points.add(new Position(738, 921));
                points.add(new Position(718, 600));
                break;

            //z letter group
            case 'z':
                points.add(new Position(400, 1116));
                points.add(new Position(1038, 1099));
                points.add(new Position(754, 858));
                points.add(new Position(397, 624));
                points.add(new Position(1070, 624));
                break;
            case 'Z':
                points.add(new Position(346, 1271));
                points.add(new Position(768, 1260));
                points.add(new Position(1168, 1271));
                points.add(new Position(845, 1011));
                points.add(new Position(524, 780));
                points.add(new Position(286, 575));
                points.add(new Position(788, 596));
                points.add(new Position(1136, 598));
                break;
            default:
                return null;
        }
        return points;
    }
}
