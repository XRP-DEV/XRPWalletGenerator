package fxml;

import io.xpring.xrpl.Utils;
import io.xpring.xrpl.Wallet;
import io.xpring.xrpl.WalletGenerationResult;
import io.xpring.xrpl.XrpException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Controller implements Initializable {

    @FXML
    private TextField tf_address;

    @FXML
    private TextField tf_mnemonic;

    @FXML
    private Button btn_generate_wallet;

    @FXML
    private ProgressIndicator indicator;

    private ExecutorService executorService = Executors.newSingleThreadExecutor();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        registerEvents();
        indicator.setVisible(false);
    }

    private void registerEvents() {
        btn_generate_wallet.setOnAction(action -> {
            btn_generate_wallet.setDisable(true);
            indicator.setVisible(true);
            executorService.submit(this::generateWallet);

        });
    }

    private void generateWallet() {
        try {
            // generate a random wallet
            WalletGenerationResult generationResult = Wallet.generateRandomWallet();
            Wallet newWallet = generationResult.getWallet();

            tf_mnemonic.setText(generationResult.getMnemonic());
            tf_address.setText(Utils.decodeXAddress(newWallet.getAddress()).address());

            btn_generate_wallet.setDisable(false);
            indicator.setVisible(false);
        } catch (XrpException e) {
            e.printStackTrace();
        }
    }


}
