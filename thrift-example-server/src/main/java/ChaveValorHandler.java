import javax.print.DocFlavor.STRING;
import org.apache.thrift.TException;
import java.util.HashMap;
import chavevalor.*;

public class ChaveValorHandler implements ChaveValor.Iface {
    private HashMap<Integer,String> kv = new HashMap<Integer, String>();
    @Override
    public String getKV(int key) throws TException {
        if(kv.containsKey(key))
            return kv.get(key);
        else
            throw new KeyNotFound();
    }
    @Override
    public String setKV(int key, String valor) throws TException {
        if(kv.containsKey(key)) {
            String aux = kv.get(key);
            kv.put(key,valor);

            return aux;
        }
        kv.put(key,valor);
        return  "";
    }
    @Override
    public void delKV(int key) throws TException {
        kv.remove(key);
    }
}