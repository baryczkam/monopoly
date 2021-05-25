package monopoly;

public class propertyCard extends Cards{
    private String nameOfProperty;
    private int homePurchasePrice;

    public propertyCard(String nameOfProperty, int homePurchasePrice) {
        this.nameOfProperty = nameOfProperty;
        this.homePurchasePrice = homePurchasePrice;
    }

    @Override
    public void showContent() {
        super.showContent();
    }
}
