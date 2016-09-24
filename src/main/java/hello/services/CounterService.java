package hello.services;

/**
 * Created by capetrel on 06/06/2016.
 */
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

/**
 * La décoration (@annotation) au niveau de la classe
 * n'est pas la meilleure méthode car elle induit des dépendances.
 * Il est préférable d'utiliser la @Configuration au niveau de l'application (cf. @Configuration).
 */
@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CounterService {

    long count;

    public long getCount() {
        return count;
    }

    public long inc(long value) {
        return this.count += value;
    }
}