package com.tepth.latte.ec.icon;

import com.joanzapata.iconify.Icon;

/**
 * Description:自定义的图标库枚举
 *
 * @author Hequn.Lee
 * @date 2017/11/06
 */

public enum EcIcons implements Icon {
    icon_iconfont5('\ue63a'),
    //购物车
    icon_gouwuche('\ue63f'),
    //购物车添加
    icon_gouwuchetianjia('\ue640'),
    //错误
    icon_cuowu('\ue641'),
    //二维码
    icon_erweima('\ue642'),
    //聚收藏
    icon_jushoucang('\ue643'),
    //垃圾箱
    icon_lajixiang('\ue645'),
    //链接
    icon_lianjie('\ue646'),
    //闹钟
    icon_naozhong('\ue648'),
    //扫一扫
    icon_saoyisao('\ue649'),
    //上翻
    icon_shangfan('\ue64a'),
    //设置
    icon_shezhi('\ue64b'),
    //声音
    icon_shengyin('\ue64c'),
    //时间
    icon_shijian('\ue64d'),
    //收货地址
    icon_shouhuodizhi('\ue64e'),
    //首页
    icon_shouye('\ue64f'),
    //刷新
    icon_shuaxin('\ue650'),
    //搜索
    icon_sousuo('\ue651'),
    //锁
    icon_suo('\ue652'),
    //提示
    icon_tishi('\ue653'),
    //完成
    icon_wancheng('\ue654'),
    //我的订单
    icon_wodedingdan('\ue655'),
    //我的反馈
    icon_wodefankui('\ue656'),
    //我的红包
    icon_wodehongbao('\ue657'),
    //我的聚划算
    icon_wodejuhuasuan('\ue659'),
    //我的优惠券
    icon_wodeyouhuiquan('\ue65a'),
    //下翻
    icon_xiafan('\ue65b'),
    //下拉
    icon_xiala('\ue65c'),
    //向上箭头
    icon_xiangshangjiantou('\ue65d'),
    //向下箭头
    icon_xiangxiajiantou('\ue65e'),
    //向右箭头
    icon_xiangyoujiantou('\ue65f'),
    //向左箭头
    icon_xiangzuojiantou('\ue660'),
    //眼睛
    icon_yanjing('\ue661'),
    //意见反馈
    icon_yijianfankui('\ue662'),
    //照相机
    icon_zhaoxiangji('\ue663'),
    //正确
    icon_zhengque('\ue664'),
    //消息中心
    icon_xiaoxizhongxin('\ue665'),
    //另存为
    icon_lingcunwei('\ue666'),
    //new
    icon_new('\ue667'),
    // 聚
    icon_ju('\ue668'),
    // 算
    icon_suan('\ue669'),
    // 划
    icon_hua('\ue66a'),
    // 聚
    icon_ju1('\ue66b'),
    //火
    icon_huo('\ue66c'),
    //30－1
    icon_301('\ue67c'),
    //7
    icon_7('\ue67d'),
    //免
    icon_mian('\ue67e'),
    //聚收藏gift
    icon_jushoucanggift('\ue684'),
    //礼物
    icon_liwu('\ue685'),
    //语音
    icon_yuyin('\ue687'),
    //支付宝
    icon_ali_pay('\ue615');

    private char character;

    EcIcons(char character) {
        this.character = character;
    }

    @Override
    public String key() {
        return name().replace('_', '-');
    }

    @Override
    public char character() {
        return character;
    }
}
