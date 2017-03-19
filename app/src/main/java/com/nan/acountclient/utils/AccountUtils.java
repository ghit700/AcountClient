package com.nan.acountclient.utils;


import com.nan.acountclient.R;

import net.steamcrafted.materialiconlib.MaterialDrawableBuilder.IconValue;

/**
 * Created by wzn on 2017/3/12.
 */

public class AccountUtils {
    public static IconValue[] TAG_DRAWABLE = {
            IconValue.SHOPPING,
            IconValue.HOME,
            IconValue.CAR,
            IconValue.MOVIE,
            IconValue.FOOD_APPLE,
            IconValue.FUNCTION,
            IconValue.FOOD_FORK_DRINK,
            IconValue.POWER,
            IconValue.GAS_CYLINDER,
            IconValue.RUN,
            IconValue.BOOK,
    };

    public static int[] TAG_NAME = {
            R.string.tag_shop,
            R.string.tag_housing,
            R.string.tag_traffic,
            R.string.tag_film,
            R.string.tag_fruit,
            R.string.tag_entertainment,
            R.string.tag_drink,
            R.string.tag_electricity_fees,
            R.string.tag_gas,
            R.string.tag_sport,
            R.string.tag_book,

    };
    public static int[] TAG_ID = {
            0,
            1,
            2,
            3,
            4,
            5,
            6,
            7,
            8,
            9,
            10,

    };

    public static int getTabPages() {
        return TAG_NAME.length % 10 == 0 ? TAG_NAME.length / 10 : TAG_NAME.length / 10 + 1;
    }

    public static IconValue getTabDrawable(int page, int position) {
        return TAG_DRAWABLE[page * 10 + position];
    }

    public static int getTabName(int page, int position) {
        return TAG_NAME[page * 10 + position];
    }

    public static int getPageTabCount(int page) {
        return TAG_NAME.length - 10 * page > 10 ? 10 : TAG_NAME.length - 10 * page;
    }

}
