package JOptionPaneExamples;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class JOptionPaneExample {

	public static void main(String[] args) {

		/*
		JOptionPane.showMessageDialog(null, "Bu bir mesajdır.","Bu bir başlıktır.", JOptionPane.PLAIN_MESSAGE);
		
		JOptionPane.showMessageDialog(null, "Bu bir bilgi mesajıdır.","Bu bir başlıktır.", JOptionPane.INFORMATION_MESSAGE);

		JOptionPane.showMessageDialog(null, "Bu bir  hata mesajıdır.","Bu bir başlıktır.", JOptionPane.ERROR_MESSAGE);

		JOptionPane.showMessageDialog(null, "Bu bir soru mesajı mı?.","Bu bir başlıktır.", JOptionPane.QUESTION_MESSAGE);
		JOptionPane.showMessageDialog(null, "Bu bir iptal mesajıdır.","Bu bir başlıktır.", JOptionPane.CANCEL_OPTION);
		
		JOptionPane.showMessageDialog(null, "Bu bir kapatma mesajıdır.","Bu bir başlıktır.", JOptionPane.CLOSED_OPTION);
		
		JOptionPane.showMessageDialog(null, "Bu bir evet/iptal mesajdır.","Bu bir başlıktır.", JOptionPane.OK_CANCEL_OPTION);
		
		JOptionPane.showMessageDialog(null, "Bu bir evet/hayır/iptal mesajıdır.","Bu bir başlıktır.", JOptionPane.YES_NO_CANCEL_OPTION);

		*/
		
		
		/*
		 * while (true) { JOptionPane.showMessageDialog(null,
		 * "Bİlgisayarında VİRÜS VAR!!!!","Bu bir başlıktır.",
		 * JOptionPane.WARNING_MESSAGE);
		 * 
		 * }
		 */

		
		//JOptionPane.showConfirmDialog(null, "SENİ ÇOK SEVİYORUMM", "Aslı'ya Mesaj...", JOptionPane.YES_OPTION);
		
		
		
	    // Kullanıcıdan ismi al
        String name = JOptionPane.showInputDialog("İsminiz ne ?");

        // Eğer kullanıcı Cancel'a bastıysa veya boş bıraktıysa
        if (name == null) {
            JOptionPane.showMessageDialog(null, "İşlem iptal edildi.", "Uyarı", JOptionPane.WARNING_MESSAGE);
        } else if (name.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "İsim girilmedi!", "Hata", JOptionPane.ERROR_MESSAGE);
        } else {
            // Başarılı durumda hoş geldin mesajı göster
            JOptionPane.showMessageDialog(null, "Merhaba, " + name + "!", "Hoş Geldiniz", JOptionPane.INFORMATION_MESSAGE);
        }
        
        //=======================================
        String[] responses = {"EVET", "hayır", "Daha Değil"};
        ImageIcon icon = new ImageIcon("BingVisualSearchIcon.png");
        
        JOptionPane.showOptionDialog(null, 
        		"Are You A Programmer?", 
        		"Secret message", 
        		JOptionPane.YES_NO_CANCEL_OPTION, 
        		JOptionPane.INFORMATION_MESSAGE,
        		icon , 
        		responses, 
        		null);


        
        
        
        

		
		
	}

}
