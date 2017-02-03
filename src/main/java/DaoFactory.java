class DaoFactory {
    private static Ads adsDao;

    static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(new Config());
        }
        return adsDao;
    }
}
