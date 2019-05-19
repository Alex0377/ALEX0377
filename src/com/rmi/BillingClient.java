package com.rmi;

import com.rmi.shared.BillingService;
import com.rmi.shared.СustomerCard;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.*;
import java.sql.SQLException;

import static java.lang.Float.valueOf;

public class BillingClient extends Application
{

    private String localhost    = "127.0.0.1";
    private String RMI_HOSTNAME = "java.rmi.server.hostname";
    private String SERVICE_PATH = "rmi://localhost/BillingService";

    private String name;
    private String god;
    private String FIO;
    private String machina;
    private String Email;
    private String komentarii;
    private String nomerkyzova;










	@FXML
	private TextField FioTEXT;
    @FXML
    private TextField FioTEXT1;
    @FXML
    private TextField FioTEXT2;
    @FXML
    private TextField FioTEXT3;
    @FXML
    private TextField FioTEXT4;
    @FXML
    private TextField FioTEXT5;
    @FXML
    private TextField FioTEXT6;
    @FXML
    private Label Errorrrget1;
    @FXML
    private Label Errorrrget11;//
    @FXML
    private Label Errorrrget;
	@FXML
	private Label mssg;
	@FXML
	private Button REGESTRahionKlient2;


    @FXML
    private void REGESTRahionKlient(ActionEvent event) throws SQLException, IOException {// при нажатии кнопки отправляет данные серверу

//Errorrrget11
        EmailValidator emailValidator =new EmailValidator();
        boolean valid = emailValidator.validateEmail(FioTEXT1.getText());
            if(!valid)  Errorrrget1.setText("Error Email"); else {
                Errorrrget1.setText("true");
                if (FioTEXT.getText().isEmpty() || FioTEXT1.getText().isEmpty() || FioTEXT2.getText().isEmpty() || FioTEXT3.getText().isEmpty() || FioTEXT4.getText().isEmpty() ||
                        FioTEXT5.getText().isEmpty() || FioTEXT6.getText().isEmpty()) {
                    Errorrrget.setText("проверти введенные данные");
                } else {
                    try {
                        if(valueOf((FioTEXT2.getText()))<100000)


                    Errorrrget.setText("Отправка прошла успешно");

                    try {
                        this.name = FioTEXT3.getText();
                        this.Email = FioTEXT1.getText();
                        this.FIO = FioTEXT.getText();
                        this.god = FioTEXT5.getText();
                        this.komentarii = FioTEXT6.getText();
                        this.machina = FioTEXT2.getText();
                        this.nomerkyzova = FioTEXT4.getText();
                        System.setProperty(RMI_HOSTNAME, localhost);
                        String objectName = SERVICE_PATH;
                        BillingService bs = (BillingService) Naming.lookup(objectName);
                        addinfoCostomer(bs);
                        Errorrrget11.setText("");
                    } catch (MalformedURLException e) {
                        Errorrrget.setText("Данные не отправлены");
                        e.printStackTrace();
                    } catch (RemoteException e) {
                        Errorrrget.setText("Данные не отправлены");
                        e.printStackTrace();
                    } catch (NotBoundException e) {
                        Errorrrget.setText("Данные не отправлены");
                        e.printStackTrace();
                        System.err.println("NotBoundException : " + e.getMessage());
                    }
                       }
                        catch (Exception E)
                        {

                            Errorrrget11.setText("Error");

                      }
                }

            }


    }


	private СustomerCard createCard ()
	{
		return new СustomerCard( name, god, FIO, machina, Email, komentarii,nomerkyzova);
	}



	private void addinfoCostomer(BillingService bs)//добавляет
	{  {


		СustomerCard card = createCard();
		try {

			bs.addNewCostomer(card);
bs.addinfoCostomer(card);

		} catch (RemoteException e) {
			System.err.println("addinfoCostomer");
		}

	}
	}

	public BillingClient()
	{

        }
	@Override
		public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("SceneKlientReegg.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("");
        stage.show();
		}

	public static void main(String[] args) {
		launch(args);
	}
}
