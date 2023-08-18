package com.panika;

public class Main {

    static String s1 = "ads-ai-monitor-agg-flink-sql\n" +
            "ads-ai-monitor-agg-flink-sql-tencent\n" +
            "ai-tag-k2k\n" +
            "ai-traffic-behavior-k22k\n" +
            "ai-traffic-behavior-k22k-ph\n" +
            "ai-weather-k2k-kfc\n" +
            "ai-weather-k2k-ph\n" +
            "apitock\n" +
            "cale-activity-k2k\n" +
            "clv-ads-coupon-kfk2ch\n" +
            "clv-ads-order-kfk2ch\n" +
            "clv-ads-task-sink-kfk2ch\n" +
            "clv-ads-task-source-kfk2ch\n" +
            "clv-ads-traffic-kfk2ch\n" +
            "clv-ads-vmall-kfk2ch\n" +
            "clv-vmall-dim-new\n" +
            "coupon-transform-job\n" +
            "Coupon_Join_OrderJob-latest-kfc\n" +
            "Coupon_Join_OrderJob-latest-la\n" +
            "Coupon_Join_OrderJob-latest-ph\n" +
            "Coupon_Join_OrderJob-latest-tb\n" +
            "couponCheckResult2ck\n" +
            "coupondata2ck\n" +
            "Crowd-Mps-Exporter-KFC\n" +
            "Crowd-Mps-Exporter-PH\n" +
            "Crowd-Processor-KFC\n" +
            "Crowd-Processor-PH\n" +
            "data-swift-oc-js\n" +
            "dw-vmall-cashOrder-new\n" +
            "dw-vmall-creditOrder-new\n" +
            "dw-vmall-ph-cash\n" +
            "dwd-cdp-traffic\n" +
            "dws-crowd-export-k2ch-flink-sql\n" +
            "flink-session-1.14.2\n" +
            "FlinkSQLSwift\n" +
            "forbidden-user-job-kfc\n" +
            "forbidden-user-job-ph\n" +
            "JSoffsetRead\n" +
            "lable-profie-job-kfc\n" +
            "lable-profie-job-ph\n" +
            "lable-sso-job-kfc\n" +
            "lable-sso-job-ph\n" +
            "ma-processGlobalTaskStream-vmall-ph\n" +
            "ma-processor-assetsTrans-coupon-kfc\n" +
            "ma-processor-assetsTrans-coupon-ph\n" +
            "ma-processor-assetsTrans-order-kfc\n" +
            "ma-processor-assetsTrans-order-otherbrand\n" +
            "ma-processor-assetsTrans-order-ph\n" +
            "ma-processor-calculate-global-coupon-ph\n" +
            "ma-processor-calculate-global-order-kfc\n" +
            "ma-processor-calculate-global-order-otherbrand\n" +
            "ma-processor-calculate-global-order-ph\n" +
            "ma-processor-calculate-personal-coupon-kfc\n" +
            "ma-processor-calculate-personal-order-kfc\n" +
            "ma-processor-calculate-personal-order-otherbrand\n" +
            "ma-processor-calculate-personal-order-ph\n" +
            "ma-processor-dcenter-task2Hbase-all\n" +
            "ma-processor-due-global-coupon-ph\n" +
            "ma-processor-due-global-order-kfc\n" +
            "ma-processor-due-global-order-otherbrand\n" +
            "ma-processor-due-global-order-ph\n" +
            "ma-processor-taskTrans-coupon-kfc\n" +
            "ma-processor-taskTrans-order-kfc\n" +
            "ma-processor-taskTrans-order-otherbrand\n" +
            "ma-processor-taskTrans-order-ph\n" +
            "ma-transferDataAssetStream-vmall-ph\n" +
            "mds-material-prime-mda-all-k2k\n" +
            "mds-material-prime-mda-uat-all-k2k\n" +
            "oc-kfk2ck\n" +
            "oc-kfk2ck-bushu\n" +
            "oc-unionId-k2k-kfc\n" +
            "oc-unionId-k2k-ph\n" +
            "ocOrder_void_ph\n" +
            "ods-ai-present-kfc-promotionCode\n" +
            "ods-appkey\n" +
            "ods-traffic-cdp-appf200-kfc\n" +
            "ods-traffic-cdp-appf200-kfc-wanguo\n" +
            "ods-traffic-cdp-appf202-kfc\n" +
            "ods-traffic-cdp-appf202-kfc-wanguo\n" +
            "ods-traffic-cdp-weappf100-kfc\n" +
            "ods-traffic-cdp-weappf100-kfc-jinshan\n" +
            "ods-traffic-cdp-weappf102-kfc\n" +
            "ods-traffic-cdp-weappf102-kfc-jinshan\n" +
            "payment_type_sync\n" +
            "swift-dining\n" +
            "TXoffsetRead";

    static String s2 = "ai-log-monitor2ck\n" +
            "coupon-transform-job\n" +
            "Coupon_Join_OrderJob-latest-kfc\n" +
            "Coupon_Join_OrderJob-latest-la\n" +
            "Coupon_Join_OrderJob-latest-ph\n" +
            "Coupon_Join_OrderJob-latest-tb\n" +
            "data-swift-oc\n" +
            "dwd-cdp-traffic-new\n" +
            "kfc-oc-encryption\n" +
            "kfcvmall2ck\n" +
            "la-oc-encryption\n" +
            "ma-processor-assetsTrans-coupon-kfc\n" +
            "ma-processor-assetsTrans-coupon-ph\n" +
            "ma-processor-assetsTrans-crowd-all\n" +
            "ma-processor-assetsTrans-deliveryDelay-ph\n" +
            "ma-processor-assetsTrans-fans-kfc\n" +
            "ma-processor-assetsTrans-fans-ph\n" +
            "ma-processor-assetsTrans-order-kfc\n" +
            "ma-processor-assetsTrans-order-otherbrand\n" +
            "ma-processor-assetsTrans-order-ph\n" +
            "ma-processor-assetsTrans-sso-all\n" +
            "ma-processor-assetsTrans-thirdCoupon-kfc\n" +
            "ma-processor-assetsTrans-traffic-kfc\n" +
            "ma-processor-assetsTrans-vgold-all\n" +
            "ma-processor-assetsTrans-vmall-kfc\n" +
            "ma-processor-assetsTrans-vmall-ph\n" +
            "ma-processor-calculate-global-coupon-ph\n" +
            "ma-processor-calculate-global-deliveryDelay-ph\n" +
            "ma-processor-calculate-global-order-kfc\n" +
            "ma-processor-calculate-global-order-otherbrand\n" +
            "ma-processor-calculate-global-order-ph\n" +
            "ma-processor-calculate-global-sso-all\n" +
            "ma-processor-calculate-global-vmall-ph\n" +
            "ma-processor-calculate-personal-coupon-kfc\n" +
            "ma-processor-calculate-personal-crowd-all\n" +
            "ma-processor-calculate-personal-fans-kfc\n" +
            "ma-processor-calculate-personal-fans-ph\n" +
            "ma-processor-calculate-personal-order-kfc\n" +
            "ma-processor-calculate-personal-order-otherbrand\n" +
            "ma-processor-calculate-personal-order-ph\n" +
            "ma-processor-calculate-personal-traffic-kfc\n" +
            "ma-processor-calculate-personal-vgold-all\n" +
            "ma-processor-calculate-personal-vmall-kfc\n" +
            "ma-processor-dcenter-dimStoreMapping-all\n" +
            "ma-processor-dcenter-task2Hbase-all\n" +
            "ma-processor-due-global-coupon-ph\n" +
            "ma-processor-due-global-order-kfc\n" +
            "ma-processor-due-global-order-otherbrand\n" +
            "ma-processor-due-global-order-ph\n" +
            "ma-processor-taskTrans-coupon-kfc\n" +
            "ma-processor-taskTrans-fans-kfc\n" +
            "ma-processor-taskTrans-fans-ph\n" +
            "ma-processor-taskTrans-order-kfc\n" +
            "ma-processor-taskTrans-order-otherbrand\n" +
            "ma-processor-taskTrans-order-ph\n" +
            "ma-processor-taskTrans-traffic-kfc\n" +
            "ma-processor-taskTrans-vgold-all\n" +
            "ma-processor-taskTrans-vmall-kfc\n" +
            "oc-order-kfc\n" +
            "oc-order-ph\n" +
            "ocparceexception2ck\n" +
            "ph-oc-encryption\n" +
            "tb-oc-encryption\n" +
            "vmall-cash\n" +
            "vmall-credit\n" +
            "vmall-prime";

    static String s3 = "ai-tag-k2h\n" +
            "ai-weather-k2h\n" +
            "cale-activity-k2h\n" +
            "dwd-ai-menu-store\n" +
            "dwd-menu-basic-classes-flink-sql\n" +
            "dwd-menu-basic-flink-sql\n" +
            "dwd-menu-basic-item-code-info-flink-sql\n" +
            "edw-mds-material-tradeup-mda-all\n" +
            "edw-mds-material-tradeup-mda-all-pqt-flink-sql\n" +
            "edw-oc-data-center-kfc-flink-sql\n" +
            "edw-oc-data-center-la-flink-sql\n" +
            "edw-oc-data-center-ph-flink-sql\n" +
            "edw-oc-data-center-tb-flink-sql\n" +
            "edw-oc-data-kfc-item-flink-sql\n" +
            "edw-oc-data-la-item-flink-sql\n" +
            "edw-oc-data-la-item-flink-sql\n" +
            "edw-oc-data-ph-item-flink-sql\n" +
            "edw-oc-data-tb-item-flink-sql\n" +
            "iceberg-coupon-check\n" +
            "iceberg-oc-detail\n" +
            "iceberg-oc-header\n" +
            "iceberg-prime-card-info\n" +
            "jpush-callback-message-flink-sql\n" +
            "jpush-push-message-flink-sql\n" +
            "mds_material_prime_mda_all-k2h\n" +
            "mds_material_prime_mda_uat_all-k2h\n" +
            "oc-unionId-k2h\n" +
            "ods-ai-ad-recommend-kfc-uat-flink-sql\n" +
            "ods-ai-banner-data-kfc-flink-sql\n" +
            "ods-ai-banner-data-ph-flink-sql\n" +
            "ods-ai-campaign-kfcclv-recommend-kfc-flink-sql\n" +
            "ods-ai-cubeproduct-recommend-kfc-flat-flink-sql\n" +
            "ods-ai-cubeproduct-recommend-kfc-flink-sql\n" +
            "ods-ai-cubetype-recommend-kfc-flink-sql\n" +
            "ods-ai-feedsfixed-recommend-kfcapp-flink-sql\n" +
            "ods-ai-hotsales-recommend-kfcd-flink-sql\n" +
            "ods-ai-hotsales-recommend-kfcp-flink-sql\n" +
            "ods-ai-masterData-secondCoupon-ph-flink-sql\n" +
            "ods-ai-materials-ad-kfc\n" +
            "ods-ai-materials-ad-ph\n" +
            "ods-ai-materials-ai-kfc\n" +
            "ods-ai-materials-ai-ph\n" +
            "ods-ai-materials-element\n" +
            "ods-ai-materials-main-kfc\n" +
            "ods-ai-materials-main-ph\n" +
            "ods-ai-menu-ph\n" +
            "ods-ai-menu-present-kfcd-flink-sql\n" +
            "ods-ai-menu-present-kfcp-flink-sql\n" +
            "ods-ai-menu-present-pco-flink-sql\n" +
            "ods-ai-menu-present-la-flink-sql\n" +
            "ods-ai-menu-present-phd-flink-sql\n" +
            "ods-ai-menu-present-pto-flink-sql\n" +
            "ods-ai-menu-present-tb-flink-sql\n" +
            "ods-ai-menu-presentEvent-pco-flink-sql\n" +
            "ods-ai-menu-presentEvent-pco-uat-flink-sql\n" +
            "ods-ai-menu-presentEvent-phd-flink-sql\n" +
            "ods-ai-menu-presentEvent-phd-uat-flink-sql\n" +
            "ods-ai-menu-presentEvent-pto-flink-sql\n" +
            "ods-ai-menu-product-extend-expanded\n" +
            "ods-ai-menu-recommend-la-flink-sql\n" +
            "ods-ai-menu-recommend-tb-flink-sql\n" +
            "ods-ai-menu-search-present-pco-flink-sql\n" +
            "ods-ai-menu-search-present-phd-flink-sql\n" +
            "ods-ai-menu-search-present-pto-flink-sql\n" +
            "ods-ai-menu-search-recommend-ph-flink-sql\n" +
            "ods-ai-menu-search-recommend-ph-uat-flink-sql\n" +
            "ods-ai-menuBanner-recommend-kfc-flink-sql\n" +
            "ods-ai-menuBanner-request-kfc-flink-sql\n" +
            "ods-ai-package-recommend-kfc-flink-sql\n" +
            "ods-ai-package-recommend-kfc-uat-flink-sql\n" +
            "ods-ai-popup-recommend-kfcapp-flink-sql\n" +
            "ods-ai-popup-recommend-kfcmini-flink-sql\n" +
            "ods-ai-present-kfc-prime\n" +
            "ods-ai-present-kfc-task\n" +
            "ods-ai-present-la-flink-sql\n" +
            "ods-ai-present-ph-flink-sql\n" +
            "ods-ai-present-tb-flink-sql\n" +
            "ods-ai-recommend-kfc-prime\n" +
            "ods-ai-recommend-la-flink-sql\n" +
            "ods-ai-recommend-ph\n" +
            "ods-ai-recommend-tb-flink-sql\n" +
            "ods-ai-recommendresult-kfc-prime\n" +
            "ods-ai-recommendresult-ph\n" +
            "ods-ai-shoppingcart-la-flink-sql\n" +
            "ods-ai-shoppingcart-ph-expanded\n" +
            "ods-ai-shoppingcart-tb-flink-sql\n" +
            "ods-ai-stockout-ph\n" +
            "ods-ai-store-ph\n" +
            "ods-ai-task-present\n" +
            "ods-ai-task-receive-event-kfc\n" +
            "ods-ai-tasker-receive\n" +
            "ods-ai-tasker-reward\n" +
            "ods-ai-tradeup-la-flink-sql\n" +
            "ods-ai-tradeup-ph\n" +
            "ods-ai-tradeup-tb-flink-sql\n" +
            "ods-ai-tradeupProduct-present-kfc-flink-sql\n" +
            "ods-ai-tradeupProduct-recommend-kfc-flink-sql\n" +
            "ods-ai-tradeupSecondCoupon-recommend-kfc-flink-sql\n" +
            "ods-ai-tradeupSecondCoupon-recommend-kfc-uat-flink-sql\n" +
            "ods-ai-tradeupSecondCoupon-recommend-ph-flink-sql\n" +
            "ods-ai-traffic-behavior-kfc-flink-sql\n" +
            "ods-ai-traffic-behavior-ph-flink-sql\n" +
            "ods-all-messagecenter-sms\n" +
            "ods-oc-data-err-mobile-flink-sql\n" +
            "ods-ph-wechat-event-realtime-flink-sql\n" +
            "ods-saas-super-member-info-flink-sql\n" +
            "ods-traffic-lbs-kfc-flink-sql\n" +
            "ods-traffic-lbs-ph-flink-sql\n" +
            "ods-userhub-actiondriven-flink-sql\n" +
            "ods_ai_present_kfc\n" +
            "ods_ai_recommend_kfc_first\n" +
            "ods_ai_recommend_kfc_task\n" +
            "ods_ai_shoppingcart_kfc_first\n" +
            "present-kfc-traffic\n" +
            "prime_all\n" +
            "prime_increment\n" +
            "prime_Prime_all\n" +
            "prime_Prime_increment\n" +
            "shopingcart_ph_hive_split\n" +
            "swift-dining";


    static String s4 = "app-kpi-activity\n" +
            "app-kpi-coupon\n" +
            "app-kpi-gift\n" +
            "com.hypers.dipp.es-n168197\n" +
            "com.hypers.trigger.eGiftCardStreaming-n168197\n" +
            "com.hypers.trigger.realGiftCardRefunded-n168197\n" +
            "com.hypers.trigger.realGiftCardStreaming-n168197\n" +
            "dipp-order-ck-stream\n" +
            "dipp-order-stream\n" +
            "dipp.coupon.place\n" +
            "dipp.coupon.use\n" +
            "FlinkSQLActivity\n" +
            "FlinkSQLActivityDashboard\n" +
            "FlinkSQLActivityDetail\n" +
            "FlinkSQLCoupon\n" +
            "FlinkSQLCouponDashboard\n" +
            "FlinkSQLCouponDetail\n" +
            "FlinkSQLGiftDetail\n" +
            "FlinkSQLHBase\n" +
            "FlinkSQLOffline\n" +
            "Realtime-Sale-Streaming-n168197\n" +
            "ys_cdc\n" +
            "ys_reward_appointment_2ck\n" +
            "ys_reward_detail_2ck\n" +
            "ys_reward_error_2ck\n" +
            "giftcard2ck\n" +
            "primecard2ck\n" +
            "refunddisorder\n" ;



    public static void main(String[] args) {
        print(s1,"金山");
        print(s2,"腾讯");
        print(s3,"DS真如");
        print(s4,"DIPP真如");

    }

    private static void print(String list,String name){
        String[] split = list.split("\n");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            if (i == split.length - 1) {
                res.append(" select \'").append(split[i]).append("\' name");
                break;
            }
            res.append(" select \'").append(split[i]).append("\' name union all");
        }
        System.out.println(name+":");
        System.out.println(res.toString());
    }
}