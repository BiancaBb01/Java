package Homework;

import java.util.*;
import java.util.Map.Entry;

public class OccurenceMap<T> {
    private final Map<T, Integer> base;

    public void add(T toAdd, int n) {
        base.put(toAdd, n + base.getOrDefault(toAdd, 0));
    }

    public void add(Map.Entry<T, Integer> e) {
        add(e.getKey(), e.getValue());
    }

    public void add(T toAdd) {
        add(toAdd, 1);
    }

    public void addAll(Collection<? extends T> ts) {
        ts.forEach(this::add);
    }

    public void addOther(OccurenceMap<T> other) {
        other.base.entrySet().forEach(this::add);
    }

    public Optional<T> extract() {
        if (base.isEmpty()) {
            return Optional.empty();
        }
        T extracted = base.keySet().stream()
                .skip(new Random().nextInt(base.size())).
                findFirst().orElseThrow(NoSuchElementException::new);
        if (base.get(extracted) == 1) {
            base.remove(extracted);
        } else {
            base.put(extracted, base.get(extracted) - 1);
        }
        return Optional.of(extracted);
    }

    // region Object Overrides
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OccurenceMap<?> that)) return false;
        return Objects.equals(base, that.base);
    }

    @Override
    public int hashCode() {
        return Objects.hash(base);
    }
    // endregion

    // region Map Overrides
    public OccurenceMap() {
        base = new HashMap<>();
    }
    public OccurenceMap(OccurenceMap<T> other) {
        base = new HashMap<>(other.base);
    }

    public boolean isEmpty() {
        return base.isEmpty();
    }

    public Set<Entry<T, Integer>> entrySet() {
        return base.entrySet();
    }

    public void forEach(java.util.function.BiConsumer<? super T, ? super Integer> action) {
        base.forEach(action);
    }

    public int count() {
        return base.values().stream().mapToInt(Integer::intValue).sum();
    }
    // endregion
}
