package View;

import Controllers.ItemController;
import Controllers.ItemInfoController;
import Models.Item;
import Models.ItemInfo;
import com.itextpdf.text.DocumentException;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Browser extends BorderPane {
    private static final View.Browser instance = new View.Browser();
    private WebView browser = new WebView();
    private WebEngine webEngine = browser.getEngine();
    private JSObject window = (JSObject) webEngine.executeScript("window");

    //Browser constructor
    public Browser() {
        //add components
        setCenter(browser);

        //add listenners
        webEngine.getLoadWorker().stateProperty().addListener(
                new ChangeListener() {
                    @Override
                    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                        if (newValue != Worker.State.SUCCEEDED) {
                            return;
                        }

                        JSObject window = (JSObject) webEngine.executeScript("window");
                        window.setMember("JavaApp", new JavaApp());
                    }
                });
        webEngine.setOnAlert(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText(event.getData());
            alert.showAndWait();
        });
        webEngine.setConfirmHandler(message -> {
            Dialog<ButtonType> confirm = new Dialog<>();
            confirm.getDialogPane().setContentText(message);
            confirm.getDialogPane().getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
            boolean result = confirm.showAndWait().filter(ButtonType.YES::equals).isPresent();

            return result ;
        });

        // load the home page
        webEngine.load("file:///" + System.getProperty("user.dir") + "/Interface/index.html");
    }

    //Signleton function
    public static View.Browser GetInstance() {
        return instance;
    }


    //JavaScript caller object
    public void Alert(String msg) {
        window.call("Alert", msg);
    }


    // JavaScript interface object
    public class JavaApp {
        public void exit() {
            Platform.exit();
        }

        public void ListAllItem() {
            ItemController itemController = ItemController.GetInstance();
            ItemInfoController itemInfoController = ItemInfoController.GetInstance();
            List<Item> itemList = itemController.FindAll();
            for (int i = 0; i < itemList.size(); i++) {
                ItemInfo tmp = itemInfoController.FindById(itemList.get(i).getIdItemInfo());
                window.call("ShowItem", tmp.getIdItemInfo(),
                        tmp.getNom(),
                        itemList.get(i).getEmplacement(),
                        tmp.getPoids(),
                        tmp.getVolume(),
                        itemList.get(i).getQuantite());
            }
        }

        public void ListAllItemRapport() {
            ItemController itemController = ItemController.GetInstance();
            ItemInfoController itemInfoController = ItemInfoController.GetInstance();
            List<Item> itemList = itemController.FindAll();
            for (int i = 0; i < itemList.size(); i++) {
                ItemInfo tmp = itemInfoController.FindById(itemList.get(i).getIdItemInfo());
                window.call("ShowItemRapport", tmp.getIdItemInfo(),
                        tmp.getNom(),
                        itemList.get(i).getEmplacement(),
                        tmp.getPoids(),
                        tmp.getVolume(),
                        itemList.get(i).getQuantite());
            }
        }

        public void ListItemById(int id) {
            ItemController itemController = ItemController.GetInstance();
            ItemInfoController itemInfoController = ItemInfoController.GetInstance();
            Item item = itemController.FindById(id);
            ItemInfo tmp = itemInfoController.FindById(item.getIdItemInfo());
            window.call("ShowItem", tmp.getIdItemInfo(),
                    tmp.getNom(),
                    item.getEmplacement(),
                    tmp.getPoids(),
                    tmp.getVolume(),
                    item.getQuantite());
        }

        public void ListItemByName(String name) {
            ItemController itemController = ItemController.GetInstance();
            ItemInfoController itemInfoController = ItemInfoController.GetInstance();
            List<Item> itemList = itemController.FindByName(name);
            for (int i = 0; i < itemList.size(); i++) {
                ItemInfo tmp = itemInfoController.FindById(itemList.get(i).getIdItemInfo());
                window.call("ShowItem", tmp.getIdItemInfo(),
                        tmp.getNom(),
                        itemList.get(i).getEmplacement(),
                        tmp.getPoids(),
                        tmp.getVolume(),
                        itemList.get(i).getQuantite());
            }
        }

        public void ListDeleteItemByUPC(int upc) {
            ItemController itemController = ItemController.GetInstance();
            ItemInfoController itemInfoController = ItemInfoController.GetInstance();
            List<Item> itemList = itemController.FindAll();
            for (int i = 0; i < itemList.size(); i++) {
                //If the upc is correct
                if (itemList.get(i).getIdItemInfo() == upc) {
                    ItemInfo tmp = itemInfoController.FindById(itemList.get(i).getIdItemInfo());
                    window.call("ShowDeleteItem",
                            tmp.getIdItemInfo(),
                            tmp.getNom(),
                            tmp.getDescription(),
                            itemList.get(i).getEmplacement(),
                            itemList.get(i).getQuantite(),
                            itemList.get(i).getIdItem());
                }
            }
        }

        public void ListDeleteItemByContainer(String emplacement) {
            ItemController itemController = ItemController.GetInstance();
            ItemInfoController itemInfoController = ItemInfoController.GetInstance();
            List<Item> itemList = itemController.FindAll();
            for (int i = 0; i < itemList.size(); i++) {
                //If the upc is correct
                if (itemList.get(i).getEmplacement().equals(emplacement)) {
                    ItemInfo tmp = itemInfoController.FindById(itemList.get(i).getIdItemInfo());
                    window.call("ShowDeleteItem",
                            tmp.getIdItemInfo(),
                            tmp.getNom(),
                            tmp.getDescription(),
                            itemList.get(i).getEmplacement(),
                            itemList.get(i).getQuantite(),
                            itemList.get(i).getIdItem());
                }
            }
        }

        public void ListAllDeleteItem() {
            ItemController itemController = ItemController.GetInstance();
            ItemInfoController itemInfoController = ItemInfoController.GetInstance();
            List<Item> itemList = itemController.FindAll();
            for (int i = 0; i < itemList.size(); i++) {
                ItemInfo tmp = itemInfoController.FindById(itemList.get(i).getIdItemInfo());
                window.call("ShowDeleteItem",
                        tmp.getIdItemInfo(),
                        tmp.getNom(),
                        tmp.getDescription(),
                        itemList.get(i).getEmplacement(),
                        itemList.get(i).getQuantite(),
                        itemList.get(i).getIdItem());
            }
        }

        public boolean DeleteItem(int id, int quantite) {
            ItemController itemController = ItemController.GetInstance();
            if (itemController.Delete(id, quantite)) {
                Alert("Objet retiré avec succes");
                return true;
            }
            return false;
        }

        public boolean CreateItem(int upc, String emplacement, String description, int quantite) {
            ItemController itemController = ItemController.GetInstance();
            if (itemController.Create(upc, emplacement, description, quantite)) {
                Alert("Objet ajouté avec succes");
                return true;
            }
            return false;
        }


        public boolean MoveItem(int id, int quantite, String emplacementNouveau) {
            ItemController itemController = ItemController.GetInstance();


            if (itemController.MoveItem(id, quantite, emplacementNouveau)) {
                Alert("Objet déplacé avec succes");
                return true;
            }
            return false;
        }

        public boolean ModifyItem(int id, String description) {
            ItemController itemController = ItemController.GetInstance();

            if (itemController.ModifyItem(id, description)) {
                Alert("Objet modifié avec succes");
                return true;
            }
            return false;
        }
        public void CreateCSVFile() {
            ItemController itemController = ItemController.GetInstance();
            ItemInfoController itemInfoController = ItemInfoController.GetInstance();
            List<Item> itemList = itemController.FindAll();
            List<ItemInfo> itemInfoList = itemInfoController.FindAll();

            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd_HH.mm");

            String dateString = date.format(new Date());
            try {
                PrintWriter writer = new PrintWriter(new File("Rapport\\" + dateString + ".csv"));
                StringBuffer csvHeader = new StringBuffer("");
                StringBuffer csvData = new StringBuffer("");
                csvHeader.append("Id,Nom,Emplacement,Poids,Volume,Quantite\n");

                // write header
                writer.write(csvHeader.toString());

                for (int i = 0; i < itemList.size(); i++) {
                    ItemInfo tmp = itemInfoController.FindById(itemList.get(i).getIdItemInfo());
                    csvData.append(tmp.getIdItemInfo());
                    csvData.append(',');
                    csvData.append(tmp.getNom());
                    csvData.append(',');
                    csvData.append(itemList.get(i).getEmplacement());
                    csvData.append(',');
                    csvData.append(tmp.getPoids());
                    csvData.append(',');
                    csvData.append(tmp.getVolume());
                    csvData.append(',');
                    csvData.append(itemList.get(i).getQuantite());
                    csvData.append('\n');
                    writer.write(csvData.toString());
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
                Alert("Une erreur c'est produite");
            }
        }

//J'ai commenté ce code car il ne fonctionne pas et je voulais testé les tris
//        public void CreateCSVFileTRI(String choixTri) {
//            ItemController itemController = ItemController.GetInstance();
//            ItemInfoController itemInfoController = ItemInfoController.GetInstance();
//            List<Item> itemList = itemController.FindAll();
//            List<ItemInfo> itemInfoList = itemInfoController.FindAll();
//
//            if (choixTri.equals("aucun")) {
//                itemInfoList = itemInfoController.FindAll();
//            }
//            else if (choixTri.equals("id")) {
//            }
//            else if (choixTri.equals("nom")){
//                itemInfoList = itemInfoController.SortByName();
//            }
//            else if (choixTri.equals("emplacement")){
//            }
//            else if (choixTri.equals("poids")){
//            }
//            else if (choixTri.equals("volume")){
//            }
//            else if (choixTri.equals("quantite")){
//            }
//
//            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd_HH.mm");
//
//            String dateString = date.format(new Date());
//            try {
//                PrintWriter writer = new PrintWriter(new File("Rapport\\" + dateString + ".csv"));
//                StringBuffer csvHeader = new StringBuffer("");
//                StringBuffer csvData = new StringBuffer("");
//                csvHeader.append("Id,Nom,Emplacement,Poids,Volume,Quantite\n");
//
//                // write header
//                writer.write(csvHeader.toString());
//
//                for (int i = 0; i < itemList.size(); i++) {
//                    ItemInfo tmp = itemInfoController.SortByName(itemList.get(i).getIdItemInfo());
//                    csvData.append(tmp.getIdItemInfo());
//                    csvData.append(',');
//                    csvData.append(tmp.getNom());
//                    csvData.append(',');
//                    csvData.append(itemList.get(i).getEmplacement());
//                    csvData.append(',');
//                    csvData.append(tmp.getPoids());
//                    csvData.append(',');
//                    csvData.append(tmp.getVolume());
//                    csvData.append(',');
//                    csvData.append(itemList.get(i).getQuantite());
//                    csvData.append('\n');
//                    writer.write(csvData.toString());
//                }
//                writer.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//                Alert("Une erreur c'est produite");
//            }
//        }

        public void CreateFile() {
            ItemController itemController = ItemController.GetInstance();
            ItemInfoController itemInfoController = ItemInfoController.GetInstance();
            List<Item> itemList = itemController.FindAll();
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd_HH.mm");

            String dateString = date.format(new Date());
            try {
                PrintWriter writer = new PrintWriter("Rapport\\" + dateString + ".txt");
                for (int i = 0; i < itemList.size(); i++) {
                    ItemInfo tmp = itemInfoController.FindById(itemList.get(i).getIdItemInfo());
                    writer.println(tmp.getIdItemInfo());
                    writer.println(tmp.getNom());
                    writer.println(itemList.get(i).getEmplacement());
                    writer.println(tmp.getPoids());
                    writer.println(tmp.getVolume());
                    writer.println(itemList.get(i).getQuantite());
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void CreateExcelFile() {
/*            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Rapport");
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd_HH.mm");
            String dateString = date.format(new Date());

            // Create a Rows
            Row headerRow = sheet.createRow(0);
                Cell cell = headerRow.createCell(0);
                cell.setCellValue("ID");

            // Write the output to a file
            try {
            FileOutputStream fileOut = new FileOutputStream("Rapport\\" + dateString + ".xlsx");
            workbook.write(fileOut);
            fileOut.close();
            } catch (IOException e) {
                e.printStackTrace();
            }*/
//            https://medium.com/@ssaurel/generating-microsoft-excel-xlsx-files-in-java-9508d1b521d9
            /*je n'ai pas pu trouver de solution pour faire cette partie'<*/
        }

        public void CreatePDFFile() throws DocumentException {
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd_HH.mm");
            String dateString = date.format(new Date());

//Ce code fonctionne mais je n'arrive pas à l'adapter à notre code
/*            Document document = new Document();
            try {
                PdfWriter.getInstance(document, new FileOutputStream("Rapport\\"+ dateString + ".pdf"));
            } catch (DocumentException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            document.open();
            Chunk chunk = new Chunk();

            document.add(chunk);
            document.close();*/

            ItemController itemController = ItemController.GetInstance();
            ItemInfoController itemInfoController = ItemInfoController.GetInstance();
            List<Item> itemList = itemController.FindAll();

            try {
                PrintWriter writer = new PrintWriter("Rapport\\" + dateString + ".txt");
                for (int i = 0; i < itemList.size(); i++) {
                    ItemInfo tmp = itemInfoController.FindById(itemList.get(i).getIdItemInfo());
                    writer.println(tmp.getIdItemInfo());
                    writer.println(tmp.getNom());
                    writer.println(itemList.get(i).getEmplacement());
                    writer.println(tmp.getPoids());
                    writer.println(tmp.getVolume());
                    writer.println(itemList.get(i).getQuantite());
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    }
