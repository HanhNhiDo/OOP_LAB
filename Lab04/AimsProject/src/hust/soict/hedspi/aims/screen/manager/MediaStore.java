package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;

import javax.swing.*;
import java.awt.*;

public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media) {

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 16));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel category = new JLabel("Category: " + media.getCategory());
        category.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(String.format("Cost: %.2f $", media.getCost()));
        cost.setAlignmentX(CENTER_ALIGNMENT);

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(category);
        this.add(cost);

        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.setAlignmentX(CENTER_ALIGNMENT);

            playButton.addActionListener(e -> {

                JOptionPane.showMessageDialog(this,
                        "Playing: " + media.getTitle(),
                        "Play Media",
                        JOptionPane.INFORMATION_MESSAGE);
                ((Playable) media).play();
            });

            this.add(playButton);
        }

        this.add(Box.createVerticalGlue());
    }
}
