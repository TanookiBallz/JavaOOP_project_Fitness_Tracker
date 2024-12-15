package com.example.fitnesstracker.Controllers;

import com.example.fitnesstracker.model.User;
import com.example.fitnesstracker.model.UserDAO;
import com.example.fitnesstracker.util.HashUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import com.example.fitnesstracker.app.AppController;

public class RegisterController {
    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField passwordField;

    /**
     * Метод для регистрации пользователя.
     */
    public void register() {
        try {
            // Проверяем, что все поля заполнены
            if (nameField.getText().isEmpty() || emailField.getText().isEmpty() || phoneField.getText().isEmpty() || passwordField.getText().isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Error", "Please fill in all fields.");
                return;
            }

            String email = emailField.getText().trim();
            String password = passwordField.getText().trim();

            // Специальная проверка для администратора
            if (email.equalsIgnoreCase("admin@gmail.com") && password.equals("9545")) {
                AppController.getInstance().showAdmin();
                return;
            }

            // Создаём нового пользователя
            User user = new User();
            user.setName(nameField.getText().trim());
            user.setEmail(email);
            user.setPasswordHash(HashUtil.hash(password));
            user.setPhone(phoneField.getText().trim());
            user.setAdmin(false); // Обычный пользователь
            user.setFirstLogin(true);

            // Сохраняем пользователя в базе данных
            UserDAO.insertUser(user);

            // Устанавливаем текущего пользователя
            AppController.getInstance().setCurrentUser(user);

            // Перенаправляем на следующую сцену
            AppController.getInstance().goNext();
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error", "An unexpected error occurred. Please try again.");
        }
    }

    /**
     * Метод для перехода на страницу логина.
     */
    @FXML
    private void goLogin() {
        AppController.getInstance().showLogin();
    }

    /**
     * Утилитный метод для показа сообщений.
     */
    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}