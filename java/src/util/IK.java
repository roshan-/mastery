package util;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IK implements ClipboardOwner{
    private static final Map<Integer, String>
            keyMap;
    static {
        HashMap<Integer, String> initMap= new HashMap<Integer, String>();
        initMap.put(1, "05V");
        initMap.put(2, "XOX");
        initMap.put(3, "ZI7");
        initMap.put(4, "OEV");
        initMap.put(5, "PFH");
        initMap.put(6, "ZT8");
        initMap.put(7, "SZY");
        initMap.put(8, "M0K");
        initMap.put(9, "741");
        initMap.put(10, "P25");
        initMap.put(11, "FGA");
        initMap.put(12, "XD0");
        initMap.put(13, "6Y0");
        initMap.put(14, "J5U");
        initMap.put(15, "65K");
        initMap.put(16, "92N");
        initMap.put(17, "VHF");
        initMap.put(18, "KGM");
        initMap.put(19, "MCN");
        initMap.put(20, "LAV");
        initMap.put(21, "YGS");
        initMap.put(22, "14M");
        initMap.put(23, "1G4");
        initMap.put(24, "QBD");
        initMap.put(25, "P7T");
        initMap.put(26, "99H");
        initMap.put(27, "46I");
        initMap.put(28, "92W");
        initMap.put(29, "0LS");
        initMap.put(30, "OVI");
        initMap.put(31, "R3N");
        initMap.put(32, "EKM");
        initMap.put(33, "459");
        initMap.put(34, "6CJ");
        initMap.put(35, "Y98");
        initMap.put(36, "F15");
        initMap.put(37, "RRT");
        initMap.put(38, "NA1");
        initMap.put(39, "OKC");
        initMap.put(40, "4QE");
        initMap.put(41, "T9M");
        initMap.put(42, "ONA");
        initMap.put(43, "YVX");
        initMap.put(44, "UDI");
        initMap.put(45, "AG9");
        initMap.put(46, "MKM");
        initMap.put(47, "96X");
        initMap.put(48, "2Q2");
        initMap.put(49, "A39");
        initMap.put(50, "VCL");
        initMap.put(51, "96H");
        initMap.put(52, "ROS");
        initMap.put(53, "49P");
        initMap.put(54, "SA9");
        initMap.put(55, "W28");
        initMap.put(56, "7XB");
        initMap.put(57, "RYS");
        initMap.put(58, "TXH");
        initMap.put(59, "HE3");
        initMap.put(60, "X4V");
        initMap.put(61, "7QL");
        initMap.put(62, "OE1");
        initMap.put(63, "UDW");
        initMap.put(64, "68V");
        initMap.put(65, "ZGV");
        initMap.put(66, "1RO");
        initMap.put(67, "U7X");
        initMap.put(68, "790");
        initMap.put(69, "UW2");
        initMap.put(70, "H75");
        initMap.put(71, "1A8");
        initMap.put(72, "UVW");
        initMap.put(73, "YTE");
        initMap.put(74, "Z6A");
        initMap.put(75, "669");
        initMap.put(76, "X9K");
        initMap.put(77, "PFJ");
        initMap.put(78, "3NO");
        initMap.put(79, "94L");
        initMap.put(80, "07V");
        initMap.put(81, "4ZL");
        initMap.put(82, "MCD");
        initMap.put(83, "E01");
        initMap.put(84, "836");
        initMap.put(85, "0F9");
        initMap.put(86, "3G6");
        initMap.put(87, "NUX");
        initMap.put(88, "6SZ");
        initMap.put(89, "ZLN");
        initMap.put(90, "SUQ");
        initMap.put(91, "FV1");
        initMap.put(92, "LA2");
        initMap.put(93, "I0Y");
        initMap.put(94, "P1K");
        initMap.put(95, "G0R");
        initMap.put(96, "DGF");
        initMap.put(97, "QBK");
        initMap.put(98, "QKR");
        initMap.put(99, "GDJ");
        initMap.put(100, "VM1");
        initMap.put(101, "X8L");
        initMap.put(102, "IIF");
        initMap.put(103, "ZOU");
        initMap.put(104, "V4U");
        initMap.put(105, "EY4");
        initMap.put(106, "6RU");
        initMap.put(107, "I76");
        initMap.put(108, "4WJ");
        initMap.put(109, "ROL");
        initMap.put(110, "LZP");
        initMap.put(111, "AN9");
        initMap.put(112, "ZV8");
        initMap.put(113, "YUX");
        initMap.put(114, "BEJ");
        initMap.put(115, "380");
        initMap.put(116, "90L");
        initMap.put(117, "OVC");
        initMap.put(118, "3DC");
        initMap.put(119, "JC7");
        initMap.put(120, "PZF");
        initMap.put(121, "320");
        initMap.put(122, "42M");
        initMap.put(123, "S64");
        initMap.put(124, "MIR");
        initMap.put(125, "66G");
        initMap.put(126, "E0P");
        initMap.put(127, "IP0");
        initMap.put(128, "9ZA");
        initMap.put(129, "IRG");
        initMap.put(130, "N4T");
        initMap.put(131, "2C8");
        initMap.put(132, "WIS");
        initMap.put(133, "T5K");
        initMap.put(134, "SQ7");
        initMap.put(135, "724");
        initMap.put(136, "QFO");
        initMap.put(137, "T5B");
        initMap.put(138, "M2O");
        initMap.put(139, "YR1");
        initMap.put(140, "XRZ");
        initMap.put(141, "SMA");
        initMap.put(142, "USC");
        initMap.put(143, "7GK");
        initMap.put(144, "XHW");
        initMap.put(145, "ED6");
        initMap.put(146, "XZY");
        initMap.put(147, "VKP");
        initMap.put(148, "G19");
        initMap.put(149, "RE5");
        initMap.put(150, "I6D");
        initMap.put(151, "DQQ");
        initMap.put(152, "9UH");
        initMap.put(153, "HX1");
        initMap.put(154, "RSQ");
        initMap.put(155, "H64");
        initMap.put(156, "64Y");
        initMap.put(157, "MLT");
        initMap.put(158, "E8B");
        initMap.put(159, "8DP");
        initMap.put(160, "8QH");
        initMap.put(161, "RCU");
        initMap.put(162, "12N");
        initMap.put(163, "HFQ");
        initMap.put(164, "NO7");
        initMap.put(165, "XWE");
        initMap.put(166, "IJJ");
        initMap.put(167, "EPF");
        initMap.put(168, "BDV");
        initMap.put(169, "PJM");
        initMap.put(170, "QJ5");
        initMap.put(171, "80E");
        initMap.put(172, "CZS");
        initMap.put(173, "NOS");
        initMap.put(174, "897");
        initMap.put(175, "C7L");
        initMap.put(176, "L7Y");
        initMap.put(177, "OWQ");
        initMap.put(178, "LRX");
        initMap.put(179, "MKG");
        initMap.put(180, "ELN");
        initMap.put(181, "FVL");
        initMap.put(182, "55F");
        initMap.put(183, "TUR");
        initMap.put(184, "OP4");
        initMap.put(185, "C94");
        initMap.put(186, "04Y");
        initMap.put(187, "J30");
        initMap.put(188, "OVI");
        initMap.put(189, "66D");
        initMap.put(190, "ZTP");
        initMap.put(191, "BOM");
        initMap.put(192, "00P");
        initMap.put(193, "3K0");
        initMap.put(194, "77X");
        initMap.put(195, "4RN");
        initMap.put(196, "ETI");
        initMap.put(197, "5BT");
        initMap.put(198, "ADZ");
        initMap.put(199, "EHB");
        initMap.put(200, "5FI");
        initMap.put(201, "7K3");
        initMap.put(202, "AER");
        initMap.put(203, "2MY");
        initMap.put(204, "AZV");
        initMap.put(205, "CF0");
        initMap.put(206, "RB8");
        initMap.put(207, "K9K");
        initMap.put(208, "T40");
        initMap.put(209, "VJ0");
        initMap.put(210, "V2C");
        initMap.put(211, "5TI");
        initMap.put(212, "AEO");
        initMap.put(213, "WIB");
        initMap.put(214, "OY2");
        initMap.put(215, "2NM");
        initMap.put(216, "NNS");
        initMap.put(217, "T39");
        initMap.put(218, "GU6");
        initMap.put(219, "AVE");
        initMap.put(220, "DDO");
        initMap.put(221, "6AQ");
        initMap.put(222, "ECR");
        initMap.put(223, "87N");
        initMap.put(224, "5R2");

        keyMap= Collections.unmodifiableMap(initMap);
    }
    public String getKey(Integer first, Integer second) {
        return keyMap.get(first)+keyMap.get(second);
    }

    /**
     * @param args
     */
    public static void printAndPaste(String[] args) {
        IK k= new IK();
        if (args.length > 1) {
            String out= k.getKey(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
            k.paste(out);
            System.out.println(out);
        }
    }
    public static void main(String[] args) {
        if (args.length > 1) {
            printAndPaste(args);
        }
        else {
            BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
            try {
                String cmdLine= reader.readLine();
                Logger.getAnonymousLogger().log(Level.INFO,"cmd: "+cmdLine);
                String[] promptedResponse= cmdLine.split(" ");
                printAndPaste(promptedResponse);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void paste(String s) {
        StringSelection sel= new StringSelection(s);
        Clipboard clipboard= Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(sel, this);
    }

    @Override
    public void lostOwnership(Clipboard clipboard, Transferable contents) {
        // TODO Auto-generated method stub

    }

}
