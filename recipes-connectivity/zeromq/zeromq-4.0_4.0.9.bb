DESCRIPTION = "ZeroMQ looks like an embeddable networking library but acts like a concurrency framework"
HOMEPAGE = "http://www.zeromq.org"
LICENSE = "LGPLv3+"
LIC_FILES_CHKSUM = "file://COPYING.LESSER;md5=d5311495d952062e0e4fbba39cbf3de1"

PACKAGECONFIG ??= "libsodium"
PACKAGECONFIG[libsodium] = "--with-libsodium, --without-libsodium, libsodium"

SRC_URI = "http://github.com/zeromq/zeromq4-x/releases/download/v${PV}/zeromq-${PV}.tar.gz \
    file://run-ptest \
"
SRC_URI[md5sum] = "93d5973e5f8521d9a843e5e19ea36baa"
SRC_URI[sha256sum] = "5afb57177d2d0798b6c06a4b355c1705abfb701e77ce7c0dff0ff11d03e3340d"

S = "${WORKDIR}/zeromq-${PV}"

#Uncomment to choose polling system manually. valid values are kqueue, epoll, devpoll, poll or select
#EXTRA_OECONF += "--with-poller=kqueue"
#CFLAGS_append = " -O0"
#CXXFLAGS_append = " -O0"

inherit autotools ptest pkgconfig

do_compile_ptest () {
    echo 'buildtest-TESTS: $(check_PROGRAMS)' >> ${B}/Makefile
    oe_runmake buildtest-TESTS
}

do_install_ptest () {
    install -d ${D}${PTEST_PATH}/tests
    install -m 0755 ${B}/.libs/test_* ${D}${PTEST_PATH}/tests
}
