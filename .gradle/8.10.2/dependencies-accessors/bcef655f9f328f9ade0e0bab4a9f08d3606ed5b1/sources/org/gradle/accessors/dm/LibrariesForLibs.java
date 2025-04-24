package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the {@code libs} extension.
 */
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final AndroidxLibraryAccessors laccForAndroidxLibraryAccessors = new AndroidxLibraryAccessors(owner);
    private final KotlinLibraryAccessors laccForKotlinLibraryAccessors = new KotlinLibraryAccessors(owner);
    private final KotlinxLibraryAccessors laccForKotlinxLibraryAccessors = new KotlinxLibraryAccessors(owner);
    private final KspLibraryAccessors laccForKspLibraryAccessors = new KspLibraryAccessors(owner);
    private final SdkruntimeLibraryAccessors laccForSdkruntimeLibraryAccessors = new SdkruntimeLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

    /**
     * Group of libraries at <b>androidx</b>
     */
    public AndroidxLibraryAccessors getAndroidx() {
        return laccForAndroidxLibraryAccessors;
    }

    /**
     * Group of libraries at <b>kotlin</b>
     */
    public KotlinLibraryAccessors getKotlin() {
        return laccForKotlinLibraryAccessors;
    }

    /**
     * Group of libraries at <b>kotlinx</b>
     */
    public KotlinxLibraryAccessors getKotlinx() {
        return laccForKotlinxLibraryAccessors;
    }

    /**
     * Group of libraries at <b>ksp</b>
     */
    public KspLibraryAccessors getKsp() {
        return laccForKspLibraryAccessors;
    }

    /**
     * Group of libraries at <b>sdkruntime</b>
     */
    public SdkruntimeLibraryAccessors getSdkruntime() {
        return laccForSdkruntimeLibraryAccessors;
    }

    /**
     * Group of versions at <b>versions</b>
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Group of bundles at <b>bundles</b>
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Group of plugins at <b>plugins</b>
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    public static class AndroidxLibraryAccessors extends SubDependencyFactory {
        private final AndroidxActivityLibraryAccessors laccForAndroidxActivityLibraryAccessors = new AndroidxActivityLibraryAccessors(owner);
        private final AndroidxLifecycleLibraryAccessors laccForAndroidxLifecycleLibraryAccessors = new AndroidxLifecycleLibraryAccessors(owner);
        private final AndroidxTestLibraryAccessors laccForAndroidxTestLibraryAccessors = new AndroidxTestLibraryAccessors(owner);

        public AndroidxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>annotation</b> with <b>androidx.annotation:annotation</b> coordinates and
         * with version reference <b>annotation</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAnnotation() {
            return create("androidx.annotation");
        }

        /**
         * Dependency provider for <b>appcompat</b> with <b>androidx.appcompat:appcompat</b> coordinates and
         * with version reference <b>appcompat</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAppcompat() {
            return create("androidx.appcompat");
        }

        /**
         * Dependency provider for <b>material</b> with <b>com.google.android.material:material</b> coordinates and
         * with version reference <b>material</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getMaterial() {
            return create("androidx.material");
        }

        /**
         * Group of libraries at <b>androidx.activity</b>
         */
        public AndroidxActivityLibraryAccessors getActivity() {
            return laccForAndroidxActivityLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.lifecycle</b>
         */
        public AndroidxLifecycleLibraryAccessors getLifecycle() {
            return laccForAndroidxLifecycleLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.test</b>
         */
        public AndroidxTestLibraryAccessors getTest() {
            return laccForAndroidxTestLibraryAccessors;
        }

    }

    public static class AndroidxActivityLibraryAccessors extends SubDependencyFactory {

        public AndroidxActivityLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>ktx</b> with <b>androidx.activity:activity-ktx</b> coordinates and
         * with version reference <b>activityKtx</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getKtx() {
            return create("androidx.activity.ktx");
        }

    }

    public static class AndroidxLifecycleLibraryAccessors extends SubDependencyFactory {

        public AndroidxLifecycleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>common</b> with <b>androidx.lifecycle:lifecycle-common</b> coordinates and
         * with version reference <b>lifecycleCommon</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCommon() {
            return create("androidx.lifecycle.common");
        }

    }

    public static class AndroidxTestLibraryAccessors extends SubDependencyFactory {

        public AndroidxTestLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>runner</b> with <b>androidx.test:runner</b> coordinates and
         * with version reference <b>androidxTestRunner</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getRunner() {
            return create("androidx.test.runner");
        }

    }

    public static class KotlinLibraryAccessors extends SubDependencyFactory {
        private final KotlinStdlibLibraryAccessors laccForKotlinStdlibLibraryAccessors = new KotlinStdlibLibraryAccessors(owner);

        public KotlinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>gradlePlugin</b> with <b>org.jetbrains.kotlin:kotlin-gradle-plugin</b> coordinates and
         * with version reference <b>kotlin</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getGradlePlugin() {
            return create("kotlin.gradlePlugin");
        }

        /**
         * Group of libraries at <b>kotlin.stdlib</b>
         */
        public KotlinStdlibLibraryAccessors getStdlib() {
            return laccForKotlinStdlibLibraryAccessors;
        }

    }

    public static class KotlinStdlibLibraryAccessors extends SubDependencyFactory {

        public KotlinStdlibLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>jdk8</b> with <b>org.jetbrains.kotlin:kotlin-stdlib-jdk8</b> coordinates and
         * with version reference <b>kotlinStdlibJdk8</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJdk8() {
            return create("kotlin.stdlib.jdk8");
        }

    }

    public static class KotlinxLibraryAccessors extends SubDependencyFactory {
        private final KotlinxCoroutinesLibraryAccessors laccForKotlinxCoroutinesLibraryAccessors = new KotlinxCoroutinesLibraryAccessors(owner);

        public KotlinxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>kotlinx.coroutines</b>
         */
        public KotlinxCoroutinesLibraryAccessors getCoroutines() {
            return laccForKotlinxCoroutinesLibraryAccessors;
        }

    }

    public static class KotlinxCoroutinesLibraryAccessors extends SubDependencyFactory {

        public KotlinxCoroutinesLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>android</b> with <b>org.jetbrains.kotlinx:kotlinx-coroutines-android</b> coordinates and
         * with version reference <b>coroutines</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAndroid() {
            return create("kotlinx.coroutines.android");
        }

        /**
         * Dependency provider for <b>core</b> with <b>org.jetbrains.kotlinx:kotlinx-coroutines-core</b> coordinates and
         * with version reference <b>coroutines</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCore() {
            return create("kotlinx.coroutines.core");
        }

    }

    public static class KspLibraryAccessors extends SubDependencyFactory {

        public KspLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>gradlePlugin</b> with <b>com.google.devtools.ksp:symbol-processing-gradle-plugin</b> coordinates and
         * with version reference <b>ksp</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getGradlePlugin() {
            return create("ksp.gradlePlugin");
        }

    }

    public static class SdkruntimeLibraryAccessors extends SubDependencyFactory {
        private final SdkruntimeActivityLibraryAccessors laccForSdkruntimeActivityLibraryAccessors = new SdkruntimeActivityLibraryAccessors(owner);
        private final SdkruntimeBackcompatLibraryAccessors laccForSdkruntimeBackcompatLibraryAccessors = new SdkruntimeBackcompatLibraryAccessors(owner);
        private final SdkruntimeToolsLibraryAccessors laccForSdkruntimeToolsLibraryAccessors = new SdkruntimeToolsLibraryAccessors(owner);
        private final SdkruntimeUiLibraryAccessors laccForSdkruntimeUiLibraryAccessors = new SdkruntimeUiLibraryAccessors(owner);

        public SdkruntimeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>sdkruntime.activity</b>
         */
        public SdkruntimeActivityLibraryAccessors getActivity() {
            return laccForSdkruntimeActivityLibraryAccessors;
        }

        /**
         * Group of libraries at <b>sdkruntime.backcompat</b>
         */
        public SdkruntimeBackcompatLibraryAccessors getBackcompat() {
            return laccForSdkruntimeBackcompatLibraryAccessors;
        }

        /**
         * Group of libraries at <b>sdkruntime.tools</b>
         */
        public SdkruntimeToolsLibraryAccessors getTools() {
            return laccForSdkruntimeToolsLibraryAccessors;
        }

        /**
         * Group of libraries at <b>sdkruntime.ui</b>
         */
        public SdkruntimeUiLibraryAccessors getUi() {
            return laccForSdkruntimeUiLibraryAccessors;
        }

    }

    public static class SdkruntimeActivityLibraryAccessors extends SubDependencyFactory {

        public SdkruntimeActivityLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>client</b> with <b>androidx.privacysandbox.activity:activity-client</b> coordinates and
         * with version reference <b>sdkRuntimeActivity</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getClient() {
            return create("sdkruntime.activity.client");
        }

        /**
         * Dependency provider for <b>core</b> with <b>androidx.privacysandbox.activity:activity-core</b> coordinates and
         * with version reference <b>sdkRuntimeActivity</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCore() {
            return create("sdkruntime.activity.core");
        }

        /**
         * Dependency provider for <b>provider</b> with <b>androidx.privacysandbox.activity:activity-provider</b> coordinates and
         * with version reference <b>sdkRuntimeActivity</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getProvider() {
            return create("sdkruntime.activity.provider");
        }

    }

    public static class SdkruntimeBackcompatLibraryAccessors extends SubDependencyFactory {

        public SdkruntimeBackcompatLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>client</b> with <b>androidx.privacysandbox.sdkruntime:sdkruntime-client</b> coordinates and
         * with version reference <b>sdkRuntimeBackcompat</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getClient() {
            return create("sdkruntime.backcompat.client");
        }

        /**
         * Dependency provider for <b>core</b> with <b>androidx.privacysandbox.sdkruntime:sdkruntime-core</b> coordinates and
         * with version reference <b>sdkRuntimeBackcompat</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCore() {
            return create("sdkruntime.backcompat.core");
        }

        /**
         * Dependency provider for <b>provider</b> with <b>androidx.privacysandbox.sdkruntime:sdkruntime-provider</b> coordinates and
         * with version reference <b>sdkRuntimeBackcompat</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getProvider() {
            return create("sdkruntime.backcompat.provider");
        }

    }

    public static class SdkruntimeToolsLibraryAccessors extends SubDependencyFactory {

        public SdkruntimeToolsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>apicompiler</b> with <b>androidx.privacysandbox.tools:tools-apicompiler</b> coordinates and
         * with version reference <b>sdkRuntimeShim</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getApicompiler() {
            return create("sdkruntime.tools.apicompiler");
        }

        /**
         * Dependency provider for <b>apigenerator</b> with <b>androidx.privacysandbox.tools:tools-apigenerator</b> coordinates and
         * with version reference <b>sdkRuntimeShim</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getApigenerator() {
            return create("sdkruntime.tools.apigenerator");
        }

        /**
         * Dependency provider for <b>apipackager</b> with <b>androidx.privacysandbox.tools:tools-apipackager</b> coordinates and
         * with version reference <b>sdkRuntimeShim</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getApipackager() {
            return create("sdkruntime.tools.apipackager");
        }

        /**
         * Dependency provider for <b>tools</b> with <b>androidx.privacysandbox.tools:tools</b> coordinates and
         * with version reference <b>sdkRuntimeShim</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getTools() {
            return create("sdkruntime.tools.tools");
        }

    }

    public static class SdkruntimeUiLibraryAccessors extends SubDependencyFactory {

        public SdkruntimeUiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>client</b> with <b>androidx.privacysandbox.ui:ui-client</b> coordinates and
         * with version reference <b>sdkRuntimeUi</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getClient() {
            return create("sdkruntime.ui.client");
        }

        /**
         * Dependency provider for <b>core</b> with <b>androidx.privacysandbox.ui:ui-core</b> coordinates and
         * with version reference <b>sdkRuntimeUi</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCore() {
            return create("sdkruntime.ui.core");
        }

        /**
         * Dependency provider for <b>provider</b> with <b>androidx.privacysandbox.ui:ui-provider</b> coordinates and
         * with version reference <b>sdkRuntimeUi</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getProvider() {
            return create("sdkruntime.ui.provider");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>activityKtx</b> with value <b>1.9.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getActivityKtx() { return getVersion("activityKtx"); }

        /**
         * Version alias <b>agp</b> with value <b>8.7.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getAgp() { return getVersion("agp"); }

        /**
         * Version alias <b>androidxTestRunner</b> with value <b>1.5.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getAndroidxTestRunner() { return getVersion("androidxTestRunner"); }

        /**
         * Version alias <b>annotation</b> with value <b>1.6.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getAnnotation() { return getVersion("annotation"); }

        /**
         * Version alias <b>appcompat</b> with value <b>1.7.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getAppcompat() { return getVersion("appcompat"); }

        /**
         * Version alias <b>coroutines</b> with value <b>1.7.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCoroutines() { return getVersion("coroutines"); }

        /**
         * Version alias <b>kotlin</b> with value <b>1.9.10</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getKotlin() { return getVersion("kotlin"); }

        /**
         * Version alias <b>kotlinStdlibJdk8</b> with value <b>1.9.10</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getKotlinStdlibJdk8() { return getVersion("kotlinStdlibJdk8"); }

        /**
         * Version alias <b>ksp</b> with value <b>1.9.10-1.0.13</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getKsp() { return getVersion("ksp"); }

        /**
         * Version alias <b>lifecycleCommon</b> with value <b>2.7.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getLifecycleCommon() { return getVersion("lifecycleCommon"); }

        /**
         * Version alias <b>material</b> with value <b>1.9.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMaterial() { return getVersion("material"); }

        /**
         * Version alias <b>privacySandboxBuildPlugin</b> with value <b>1.0.0-alpha02</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getPrivacySandboxBuildPlugin() { return getVersion("privacySandboxBuildPlugin"); }

        /**
         * Version alias <b>sdkRuntimeActivity</b> with value <b>1.0.0-alpha01</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getSdkRuntimeActivity() { return getVersion("sdkRuntimeActivity"); }

        /**
         * Version alias <b>sdkRuntimeBackcompat</b> with value <b>1.0.0-alpha16</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getSdkRuntimeBackcompat() { return getVersion("sdkRuntimeBackcompat"); }

        /**
         * Version alias <b>sdkRuntimeShim</b> with value <b>1.0.0-alpha12</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getSdkRuntimeShim() { return getVersion("sdkRuntimeShim"); }

        /**
         * Version alias <b>sdkRuntimeUi</b> with value <b>1.0.0-alpha14</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getSdkRuntimeUi() { return getVersion("sdkRuntimeUi"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Dependency bundle provider for <b>coroutines</b> which contains the following dependencies:
         * <ul>
         *    <li>org.jetbrains.kotlinx:kotlinx-coroutines-core</li>
         *    <li>org.jetbrains.kotlinx:kotlinx-coroutines-android</li>
         * </ul>
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> getCoroutines() {
            return createBundle("coroutines");
        }

        /**
         * Dependency bundle provider for <b>sdkruntimeActivity</b> which contains the following dependencies:
         * <ul>
         *    <li>androidx.privacysandbox.activity:activity-core</li>
         *    <li>androidx.privacysandbox.activity:activity-client</li>
         *    <li>androidx.privacysandbox.activity:activity-provider</li>
         * </ul>
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> getSdkruntimeActivity() {
            return createBundle("sdkruntimeActivity");
        }

        /**
         * Dependency bundle provider for <b>sdkruntimeBackcompat</b> which contains the following dependencies:
         * <ul>
         *    <li>androidx.privacysandbox.sdkruntime:sdkruntime-core</li>
         *    <li>androidx.privacysandbox.sdkruntime:sdkruntime-client</li>
         *    <li>androidx.privacysandbox.sdkruntime:sdkruntime-provider</li>
         * </ul>
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> getSdkruntimeBackcompat() {
            return createBundle("sdkruntimeBackcompat");
        }

        /**
         * Dependency bundle provider for <b>sdkruntimeRASDK</b> which contains the following dependencies:
         * <ul>
         *    <li>androidx.privacysandbox.sdkruntime:sdkruntime-core</li>
         *    <li>androidx.privacysandbox.sdkruntime:sdkruntime-client</li>
         *    <li>androidx.privacysandbox.ui:ui-core</li>
         *    <li>androidx.privacysandbox.ui:ui-client</li>
         *    <li>androidx.privacysandbox.activity:activity-core</li>
         *    <li>androidx.privacysandbox.activity:activity-client</li>
         * </ul>
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> getSdkruntimeRASDK() {
            return createBundle("sdkruntimeRASDK");
        }

        /**
         * Dependency bundle provider for <b>sdkruntimeRESDK</b> which contains the following dependencies:
         * <ul>
         *    <li>androidx.privacysandbox.sdkruntime:sdkruntime-core</li>
         *    <li>androidx.privacysandbox.sdkruntime:sdkruntime-provider</li>
         *    <li>androidx.privacysandbox.ui:ui-core</li>
         *    <li>androidx.privacysandbox.ui:ui-provider</li>
         *    <li>androidx.privacysandbox.activity:activity-core</li>
         *    <li>androidx.privacysandbox.activity:activity-provider</li>
         *    <li>androidx.privacysandbox.tools:tools</li>
         * </ul>
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> getSdkruntimeRESDK() {
            return createBundle("sdkruntimeRESDK");
        }

        /**
         * Dependency bundle provider for <b>sdkruntimeUI</b> which contains the following dependencies:
         * <ul>
         *    <li>androidx.privacysandbox.ui:ui-core</li>
         *    <li>androidx.privacysandbox.ui:ui-client</li>
         *    <li>androidx.privacysandbox.ui:ui-provider</li>
         * </ul>
         * <p>
         * This bundle was declared in catalog libs.versions.toml
         */
        public Provider<ExternalModuleDependencyBundle> getSdkruntimeUI() {
            return createBundle("sdkruntimeUI");
        }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

}
