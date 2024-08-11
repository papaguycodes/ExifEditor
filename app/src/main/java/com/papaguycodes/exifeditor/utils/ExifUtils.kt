//💡In the Beginning, PaPaGuy wrote beautiful Codes < /> 💜❤️ //
package com.papaguycodes.exifeditor.utils

import android.media.ExifInterface

object ExifUtils {

    fun getExifTags(exif: ExifInterface): Map<String, String> {
        val tags = mapOf(
            "Date & Time" to ExifInterface.TAG_DATETIME,
            "Date & Time Original" to ExifInterface.TAG_DATETIME_ORIGINAL,
            "Date & Time Digitized" to ExifInterface.TAG_DATETIME_DIGITIZED,
            "GPS Latitude" to ExifInterface.TAG_GPS_LATITUDE,
            "GPS Longitude" to ExifInterface.TAG_GPS_LONGITUDE,
            "GPS Altitude" to ExifInterface.TAG_GPS_ALTITUDE,
            "GPS Processing Method" to ExifInterface.TAG_GPS_PROCESSING_METHOD,
            "GPS Datestamp" to ExifInterface.TAG_GPS_DATESTAMP,
            "Image Width" to ExifInterface.TAG_IMAGE_WIDTH,
            "Image Height" to ExifInterface.TAG_IMAGE_LENGTH,
            "Orientation" to ExifInterface.TAG_ORIENTATION,
            "Make" to ExifInterface.TAG_MAKE,
            "Model" to ExifInterface.TAG_MODEL,
            "Software" to ExifInterface.TAG_SOFTWARE,
            "Flash" to ExifInterface.TAG_FLASH,
            "Focal Length" to ExifInterface.TAG_FOCAL_LENGTH,
            "Focal Length in 35mm Film" to ExifInterface.TAG_FOCAL_LENGTH_IN_35MM_FILM,
            "Exposure Time" to ExifInterface.TAG_EXPOSURE_TIME,
            "Exposure Bias Value" to ExifInterface.TAG_EXPOSURE_BIAS_VALUE,
            "Aperture Value" to ExifInterface.TAG_APERTURE_VALUE,
            "Max Aperture Value" to ExifInterface.TAG_MAX_APERTURE_VALUE,
            "ISO Speed Ratings" to ExifInterface.TAG_ISO_SPEED_RATINGS,
            "Shutter Speed Value" to ExifInterface.TAG_SHUTTER_SPEED_VALUE,
            "White Balance" to ExifInterface.TAG_WHITE_BALANCE,
            "Exposure Mode" to ExifInterface.TAG_EXPOSURE_MODE,
            "Exposure Program" to ExifInterface.TAG_EXPOSURE_PROGRAM,
            "Scene Capture Type" to ExifInterface.TAG_SCENE_CAPTURE_TYPE,
            "Contrast" to ExifInterface.TAG_CONTRAST,
            "Saturation" to ExifInterface.TAG_SATURATION,
            "Sharpness" to ExifInterface.TAG_SHARPNESS,
            "Brightness Value" to ExifInterface.TAG_BRIGHTNESS_VALUE,
            "Metering Mode" to ExifInterface.TAG_METERING_MODE,
            "Light Source" to ExifInterface.TAG_LIGHT_SOURCE,
            "Digital Zoom Ratio" to ExifInterface.TAG_DIGITAL_ZOOM_RATIO,
            "Gain Control" to ExifInterface.TAG_GAIN_CONTROL,
            "Subject Distance Range" to ExifInterface.TAG_SUBJECT_DISTANCE_RANGE,
            "File Source" to ExifInterface.TAG_FILE_SOURCE
        )

        val exifData = mutableMapOf<String, String>()

        for ((key, tag) in tags) {
            val value = exif.getAttribute(tag)
            if (value != null) {
                exifData[key] = value
            }
        }

        return exifData
    }
}
