//package com.android.mustafa.applicationb.test
//
//import android.content.ContentResolver
//import android.content.ContentUris
//import android.net.Uri
//import android.provider.ContactsContract
//
//class MyContactsDataSource(private val contentResolver: ContentResolver) {
//
//    fun fetchContacts(): List<MyContact> {
//        val result: MutableList<MyContact> = mutableListOf()
//
//        val cursor = contentResolver.query(
//            ContactsContract.Data.CONTENT_URI,
//            arrayOf(
//                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
//                ContactsContract.CommonDataKinds.Phone.CONTACT_ID
//            ),
//            null,
//            null,
//            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
//        )
//        cursor?.let {
//            cursor.moveToFirst()
//            while (!cursor.isAfterLast) {
//                result.add(
//                    MyContact(
//                        cursor.getString(0),
//                        cursor.getString(1).toContactImageUri()
//                    )
//                ) //add the item
//                cursor.moveToNext()
//            }
//            cursor.close()
//        }
//
//        return result.toList()
//    }
//
//}
//
//fun String.toContactImageUri() = Uri.withAppendedPath(
//    ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, this.toLong()),
//    ContactsContract.Contacts.Photo.CONTENT_DIRECTORY
//).toString()