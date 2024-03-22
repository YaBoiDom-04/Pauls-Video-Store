class Video {
    private String barcode;
    private String title;

    public Video(String barcode, String title) {
        this.barcode = barcode;
        this.title = title;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getTitle() {
        return title;
    }
}