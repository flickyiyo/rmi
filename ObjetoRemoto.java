class ObjetoRemoto {

    private String ip;
    private ChatInterface obj;

    public ObjetoRemoto() {

    }

    /**
     * @param ip the ip to set
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * @param obj the obj to set
     */
    public void setObj(ChatInterface obj) {
        this.obj = obj;
    }

    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @return the obj
     */
    public ChatInterface getObj() {
        return obj;
    }

}