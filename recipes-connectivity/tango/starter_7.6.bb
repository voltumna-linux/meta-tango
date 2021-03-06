DESCRIPTION = "Tango Starter"
HOMEPAGE = "http://www.tango-controls.org"
LICENSE = "GPLv3+"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"

DEPENDS += "libtango"

SRCREV = "Starter-${PV}"
SRC_URI = "git://gitlab.com/tango-controls/${BPN}.git;protocol=https;branch=main \
		file://01-log-file-home-no-ds.log.patch \
		file://02-starter-stdout.patch \
		file://simplify-Makefile.patch \
		file://Starter.sh \
		file://starter.service \
	"

S = "${WORKDIR}/git"

FILES_${PN} += "${bindir}"

SYSTEMD_SERVICE_${PN} = "starter.service"

do_install_append() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/Starter ${WORKDIR}/Starter.sh ${D}${bindir}

	install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/starter.service ${D}${systemd_unitdir}/system
}

USERADD_PACKAGES = "${PN}"
GROUPADD_PARAM_${PN} = "--system tango"
USERADD_PARAM_${PN} = "--system -d / -M -N -g tango --shell /bin/nologin starter"

inherit useradd pkgconfig systemd
