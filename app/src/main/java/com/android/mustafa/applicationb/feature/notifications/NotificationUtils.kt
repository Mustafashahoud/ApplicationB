package com.android.mustafa.applicationb.feature.notifications

import com.android.mustafa.applicationb.feature.notifications.NotificationUtils.SocialPackageNames.FACEBOOK_PACKAGE
import com.android.mustafa.applicationb.feature.notifications.NotificationUtils.SocialPackageNames.INSTAGRAM_PACKAGE
import com.android.mustafa.applicationb.feature.notifications.NotificationUtils.SocialPackageNames.LINKEDIN_PACKAGE
import com.android.mustafa.applicationb.feature.notifications.NotificationUtils.SocialPackageNames.MASSENGER_PACKAGE
import com.android.mustafa.applicationb.feature.notifications.NotificationUtils.SocialPackageNames.TWITTER_PACKAGE
import com.android.mustafa.applicationb.feature.notifications.NotificationUtils.SocialPackageNames.WHATSAPP_PACKAGE

object NotificationUtils {
    fun getNotificationCategory(packageName: String): Category {
        return when (packageName) {
            FACEBOOK_PACKAGE -> Category.SOCIAL
            MASSENGER_PACKAGE -> Category.SOCIAL
            WHATSAPP_PACKAGE -> Category.SOCIAL
            INSTAGRAM_PACKAGE -> Category.SOCIAL
            LINKEDIN_PACKAGE -> Category.SOCIAL
            TWITTER_PACKAGE -> Category.SOCIAL
            else -> Category.OTHER
        }
    }

    object SocialPackageNames {
        const val FACEBOOK_PACKAGE = "com.facebook.katana"
        const val MASSENGER_PACKAGE = "com.facebook.orca"
        const val WHATSAPP_PACKAGE = "com.whatsapp"
        const val INSTAGRAM_PACKAGE = "com.instagram.android"
        const val LINKEDIN_PACKAGE = "com.linkedin.android"
        const val TWITTER_PACKAGE = "com.twitter.android"
    }


}