package com.apress.cems.beans.scalars;

import com.apress.cems.beans.ci.SimpleBean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class EmptyCollectionHolder {

    private List<SimpleBean> simpleBeanList;
    private Set<SimpleBean> simpleBeanSet;
    private Map<String, SimpleBean> simpleBeanMap;

    public void setSimpleBeanList(List<SimpleBean> simpleBeanList){
        this.simpleBeanList = simpleBeanList;
    }

    public void setSimpleBeanSet(Set<SimpleBean> simpleBeanSet){
        this.simpleBeanSet = simpleBeanSet;
    }

    public void setSimpleBeanMap(Map<String, SimpleBean> simpleBeanMap){
        this.simpleBeanMap = simpleBeanMap;
    }

    @Override
    public String toString() {
        return "CollectionHolder{ + " +
                "simpleBeanList=" + (simpleBeanList == null ? 0 : simpleBeanList.size()) +
                "simpleBeanSet="  + (simpleBeanList == null ? 0 : simpleBeanSet.size()) +
                "simpleBeanMap="  + (simpleBeanMap == null ? 0 : simpleBeanMap.size() )+
                '}';
    }
}
