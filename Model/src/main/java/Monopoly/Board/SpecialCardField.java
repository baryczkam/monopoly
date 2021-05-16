package Monopoly.Board;

import Monopoly.Player.PlayerInterface;
import Monopoly.SpecialCard.SpecialCardInterface;

public class SpecialCardField extends Field {
    private SpecialCardInterface card;

    public SpecialCardInterface getCard() {
        return card;
    }

    public void setCard(SpecialCardInterface card) {
        this.card = card;
    }

    public SpecialCardField(int fieldIndex, PlayerInterface player, SpecialCardInterface card) {
        super(fieldIndex, player);
        this.card = card;
    }

}
