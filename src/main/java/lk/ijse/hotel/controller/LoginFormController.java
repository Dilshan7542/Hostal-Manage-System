package lk.ijse.hotel.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import lk.ijse.hotel.bo.BOFactory;
import lk.ijse.hotel.bo.BOType;
import lk.ijse.hotel.bo.custom.UserBO;
import lk.ijse.hotel.bo.custom.impl.UserBOImpl;
import lk.ijse.hotel.dto.UserDTO;

import java.io.IOException;
import java.util.List;

public class LoginFormController {
    static String NAME_USER;
    public AnchorPane pane;
    public TextField txtEmail;
    public PasswordField txtPwd;
    public CheckBox chBox;
    public TextField txtPwdField;
    UserBO userBO = (UserBOImpl) BOFactory.getInstance().getBO(BOType.USER);
     List<UserDTO> allUser;
    {
        try {
            allUser = userBO.getAllUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnLogin(ActionEvent actionEvent) throws IOException {
        checkLogin();
    }

    private void checkLogin() throws IOException {
        String pwd = "";
        if (chBox.isSelected()) {
            pwd = txtPwdField.getText();
        } else {
            pwd = txtPwd.getText();
        }
        boolean isExist=false;
        for (UserDTO userDTO : allUser) {
            if (userDTO.getPassword().equals(pwd) && userDTO.getEmail().equals(txtEmail.getText())) {
                NAME_USER = userDTO.getName();
                final Stage window = (Stage) pane.getScene().getWindow();
                window.close();
                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/Dashboard.fxml")));
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setMaximized(true);
                stage.getIcons().add(new Image("/view/assets/img/icon.png"));
                stage.setTitle("Dashboard");
                stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent windowEvent) {
                        Platform.exit();
                       System.exit(0);
                    }
                });
                stage.show();
                isExist=true;
            }
        }
        if(!isExist){
        new Alert(Alert.AlertType.WARNING,"Invalid Email OR Password").show();

        }
    }

    public void btnTxtEmail(ActionEvent actionEvent) {
        for (UserDTO u : allUser) {
            if (txtEmail.getText().equals(u.getEmail())) {
                txtPwd.requestFocus();
                return;
            }
        }
        new Alert(Alert.AlertType.WARNING,"Invalid Email").show();

    }

    public void btnTxtPwd(ActionEvent actionEvent) throws IOException {
        checkLogin();
    }

    public void btnChBox(ActionEvent actionEvent) {
        if (chBox.isSelected()) {
            txtPwd.setVisible(false);
            txtPwdField.setVisible(true);
            txtPwdField.setText(txtPwd.getText());

        } else {
            txtPwd.setVisible(true);
            txtPwdField.setVisible(false);
            txtPwd.setText(txtPwdField.getText());
        }

    }
}
