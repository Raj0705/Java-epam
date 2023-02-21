package com.epam.rd.contactbook;

public class Contact {
    ContactInfo[] info = new ContactInfo[10];
    private String value;

    public Contact(String contactName) {
        this.value = contactName;
        info[0] = new ContactInfo() {
            private String title = "Name";

            @Override
            public String getTitle() {
                return title;
            }

            @Override
            public String getValue() {
                return value;
            }
        };
    }

    public void rename(String newName) {
        if (newName == null || newName == "") {
        } else {
            value = newName;
        }
    }

    private class NameContactInfo implements ContactInfo {
        public String getTitle() {
            return "Name";
        };

        public String getValue() {
            ContactInfo i = info[0];
            return i.getValue();
        };
    }

    public static class Email implements ContactInfo {
        private String localPart;
        private String domain;

        Email(String localPart, String domain) {
            this.domain = domain;
            this.localPart = localPart;
        }

        public String getTitle() {
            return "Email";
        };

        public String getValue() {
            return localPart + "@" + domain;
        };
    }

    public Email addEmail(String localPart, String domain) {
        Email email = null;
        for (int i = 2; i < 5; i++) {
            if (info[i] == null) {
                email = new Email(localPart, domain);
                info[i] = email;
                return email;
            }
        }
        return email;
    }

    public Email addEpamEmail(String firstname, String lastname) {
        Email email = null;
        for (int i = 2; i < 5; i++) {
            if (info[i] == null) {
                email = new Email(firstname + "_" + lastname, "epam.com") {
                    public String getTitle() {
                        return "Epam Email";
                    }
                };
                info[i] = email;
                return email;
            }
        }
        return email;

    }

    public ContactInfo addPhoneNumber(int code, String number) {
        ContactInfo inf = null;
        if (info[1] == null) {
            inf = new ContactInfo() {
                private String numberPhone = "+" + code + " " + number;

                @Override
                public String getTitle() {
                    return "Tel";
                }

                @Override
                public String getValue() {
                    return numberPhone;
                };
            };
            info[1] = inf;
        }
        return inf;

    }

    public static class Social implements ContactInfo {
        private String title;
        private String URL;

        public Social(String title, String URL) {
            this.title = title;
            this.URL = URL;
        }

        @Override
        public String getTitle() {
            return title;
        }

        @Override
        public String getValue() {
            return URL;
        }

    }

    public Social addTwitter(String twitterId) {
        Social social = null;
        for (int i = 5; i < 10; i++) {
            if (info[i] == null) {
                social = new Social("Twitter", twitterId);
                info[i] = social;
                return social;
            }
        }
        return social;
    }

    public Social addInstagram(String instagramId) {
        Social social = null;
        for (int i = 5; i < 10; i++) {
            if (info[i] == null) {
                social = new Social("Instagram", instagramId);
                info[i] = social;
                return social;
            }
        }
        return social;
    }

    public Social addSocialMedia(String title, String id) {
        Social social = null;
        for (int i = 5; i < 10; i++) {
            if (info[i] == null) {
                social = new Social(title, id);
                info[i] = social;
                return social;
            }
        }
        return social;
    }

    public ContactInfo[] getInfo() {
        int counter = 0;
        for (ContactInfo i : info) {
            if (i != null) {
                counter++;
            }
        }
        ContactInfo[] infoCopy = new ContactInfo[counter];
        int j = 0;
        for (ContactInfo i : info) {
            if (i != null) {
                infoCopy[j] = i;
                j++;
            }
        }

        return infoCopy;

    }
}