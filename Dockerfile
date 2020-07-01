FROM ubuntu:16.04
MAINTAINER Jeganathan Swaminathan <mail2jegan@gmail.com>

RUN apt-get update && apt-get install -y openssh-server python-minimal
RUN mkdir /var/run/sshd
RUN echo 'root:root' | chpasswd
RUN sed -i 's/PermitRootLogin prohibit-password/PermitRootLogin yes/' /etc/ssh/sshd_config

# SSH login fix. Otherwise user is kicked off after login
RUN sed 's@session\s*required\s*pam_loginuid.so@session optional pam_loginuid.so@g' -i /etc/pam.d/sshd

RUN mkdir -p /root/.ssh

COPY authorized_keys /root/.ssh/authorized_keys

EXPOSE 22
EXPOSE 8080

CMD ["/usr/sbin/sshd", "-D"]
