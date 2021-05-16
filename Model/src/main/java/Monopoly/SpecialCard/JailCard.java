package Monopoly.SpecialCard;

import Monopoly.Player.PlayerInterface;

public class JailCard extends SpecialCard{
    private Status status;

    public JailCard(PlayerInterface player, Status status) {
        super(player);
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public void performAction() {
        super.performAction();
    }
}
