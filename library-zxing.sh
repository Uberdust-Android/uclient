#!/bin/bash

ZXING_SVN=http://zxing.googlecode.com/svn/trunk
ZXING_CHECKSUM=library-zxing.sum

function getlib {
    echo "Exporting source from SVN..."
    svn export $ZXING_SVN/core library-zxing/core
    svn export $ZXING_SVN/android library-zxing/android
    echo "Patching zxing android library project"
    echo "android.library=true" >> library-zxing/android/project.properties
    echo "Calculating MD5 hash..."
    find library-zxing/ -type f -print0 | xargs -0 md5sum >> $ZXING_CHECKSUM
}

echo "Checking existing zxing library source integrity..."
if [ ! -f $ZXING_CHECKSUM ]; then
    rm -f $ZXING_CHECKSUM
    rm -rf library-zxing/
    echo "No checksum file was found!"
    getlib
    exit
fi
if [[ `md5sum -c $ZXING_CHECKSUM 2>/dev/null | grep FAILED | wc -l` > 0 ]]; then
    rm -f $ZXING_CHECKSUM
    rm -rf library-zxing/
    echo "Existing zxing source is corrupted!"
    getlib
    exit
fi

echo "zxing library existing source OK"
